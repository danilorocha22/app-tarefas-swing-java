package com.danilorocha.repositories;

import com.danilorocha.entities.Project;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.danilorocha.connection.ConnectionFactory.getConnection;
import static com.danilorocha.entities.Project.newProject;

public class ProjectRepository {

    public void save(Project project) {
        String sql = "INSERT INTO projects(" +
                "name, " +
                "description, " +
                "createDate, " +
                "updateDate) VALUES(?, ?, ?, ?)";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(project.getCreateDate()));
            statement.setTimestamp(4, Timestamp.valueOf(project.getUpdateDate()));
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar salvar o projeto ", e);
        }//catch
    }//save

    public void update(Project project) {
        String sql = "UPDATE projects SET " +
                "name = ?, " +
                "description = ?, " +
                "createDate = ?, " +
                "updateDate = ? " +
                "WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, project.getName());
            statement.setString(2, project.getDescription());
            statement.setTimestamp(3, Timestamp.valueOf(project.getCreateDate()));
            statement.setTimestamp(4, Timestamp.valueOf(project.getUpdateDate()));
            statement.setLong(5, project.getId());
            statement.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar atualizar o projeto ", e);
        }//catch
    }//update

    public void remove(Long projectId) {
        String sql = "DELETE FROM projects WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, projectId);
            statement.execute();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar deletar o projeto ", e);
        }//catch
    }//remove

    public Optional<List<Project>> getAll() {
        String sql = "SELECT * FROM projects";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {

            List<Project> projects = new ArrayList<>();
            while (resultSet.next()) {
                Project project = newProject(resultSet.getLong("id"), resultSet.getString("name"),
                        resultSet.getString("description"), resultSet.getTimestamp("createDate").toLocalDateTime(),
                        resultSet.getTimestamp("updateDate").toLocalDateTime());
                projects.add(project);
            }
            return Optional.of(projects);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar listar todos os projetos ", e);
        }//catch
    }//getAll

    public Project getById(Long projectId) {
        String sql = "SELECT * FROM projects WHERE id = ?";

        try (Connection conn = getConnection(); PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setLong(1, projectId);

            try (ResultSet resultSet = statement.executeQuery()){
                Project project = null;
                while (resultSet.next()) {
                    project = newProject(resultSet.getLong("id"), resultSet.getString("name"),
                            resultSet.getString("description"),
                            resultSet.getTimestamp("createDate").toLocalDateTime(),
                            resultSet.getTimestamp("updateDate").toLocalDateTime());
                }
                return project;
            } catch (Exception e) {
                throw new RuntimeException("Erro ao tentar recuperar o projeto ", e);
            }
        } catch (Exception e) {
            throw new RuntimeException("Erro ao tentar recuperar o projeto ", e);
        }//catch
    }//getById

}//class
