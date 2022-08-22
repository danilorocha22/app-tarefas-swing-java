package com.danilorocha.repositories;

import com.danilorocha.connection.ConnectionFactory;
import static com.danilorocha.connection.ConnectionFactory.getConnection;
import com.danilorocha.entities.Task;
import static com.danilorocha.entities.Task.newTask;
import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    public void save(Task task) {
        String sql = "INSERT INTO tasks(" +
                "idProject, " +
                "name, " +
                "description, " +
                "completed, " +
                "note, " +
                "deadline, " +
                "createDate, " +
                "updateDate) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, task.getIdProject());
            statement.setString(2, task.getName());
            statement.setString(3, task.getDescription());
            statement.setBoolean(4, task.isCompleted());
            statement.setString(5, task.getNote());
            statement.setDate(6, Date.valueOf(task.getDeadline()));
            statement.setTimestamp(7, Timestamp.valueOf(task.getCreateDate()));
            statement.setTimestamp(8, Timestamp.valueOf(task.getUpdateDate()));
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar salvar a tarefa", e);
        }//catch
    }//save

    public void update(Task task) {
        String sql = "UPDATE tasks SET " +
                "id = ?, " +
                "idProject = ?, " +
                "name = ?, " +
                "description = ?, " +
                "completed = ?, " +
                "note = ?, " +
                "deadline = ?, " +
                "createDate = ?, " +
                "updateDate = ? " +
                "WHERE id = ?";

        try (Connection conn = getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, task.getId());
            statement.setLong(2, task.getIdProject());
            statement.setString(3, task.getName());
            statement.setString(4, task.getDescription());
            statement.setBoolean(5, task.isCompleted());
            statement.setString(6, task.getNote());
            statement.setDate(7, Date.valueOf(task.getDeadline()));
            statement.setTimestamp(8, Timestamp.valueOf(task.getCreateDate()));
            statement.setTimestamp(9, Timestamp.valueOf(task.getUpdateDate()));
            statement.setLong(10, task.getId());
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar atualizar a tarefa", e);
        }//catch
    }//update

    public void removeById(Long taskId) {
        String sql = "DELETE FROM tasks WHERE id = ?";

        try (Connection conn = ConnectionFactory.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, taskId);
            statement.execute();

        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar deletar a tarefa ", e);
        }//catch
    }//remove

    public List<Task> getAll(Long idProject) {
        try (Connection conn = getConnection();
             PreparedStatement statement = createPreparedStatement(conn, idProject);
             ResultSet resultSet = statement.executeQuery()) {

            List<Task> tasks = new ArrayList<>();

            while (resultSet.next()) {
                Task task = newTask(resultSet.getLong("id"), resultSet.getLong("idProject"),
                        resultSet.getString("name"), resultSet.getString("description"),
                        resultSet.getString("note"), resultSet.getBoolean("completed"),
                        resultSet.getDate("deadline").toLocalDate(),
                        resultSet.getTimestamp("createDate").toLocalDateTime(),
                        resultSet.getTimestamp("updateDate").toLocalDateTime());
                tasks.add(task);
            }//while

            return tasks;

        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar visualizar todas as tarefas ", e);
        }//catch
    }//getAll

    private PreparedStatement createPreparedStatement(Connection conn, Long idProject) throws Exception {
        String query = "SELECT * FROM tasks WHERE idProject = ?";
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setLong(1, idProject);
        return statement;
    }//createdPreparedStatement

}//class
