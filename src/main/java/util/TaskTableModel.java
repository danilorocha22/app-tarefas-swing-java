/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import com.danilorocha.entities.Task;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 *
 * @author danilo
 */
public class TaskTableModel extends AbstractTableModel {
    
    private String[] columns = { "Nome", "Descrição", "Prazo", "Tarefa Concluída",
                                "Editar", "Excluir" };
    
    private List<Task> tasks;

    public TaskTableModel() {
        tasks = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return tasks.size();
    }

    @Override
    public int getColumnCount() {
        return columns.length;
    }

    @Override
    public Object getValueAt(int rowI, int colI) {
        switch (colI) {
            case 1:
                return tasks.get(rowI).getName();
                
            case 2:
                return tasks.get(rowI).getDescription();
                
            case 3:
                return tasks.get(rowI).getDeadline();
                
            case 4:
                return tasks.get(rowI).isCompleted();
                
            case 5:
                return "";
            
            case 6:
                return "";
                
            default:
                return "Dados não encontrados";
        }//switch
    }//getValueAt

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex == 3;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (this.tasks.isEmpty())
            return Object.class;
        return this.getValueAt(0, columnIndex).getClass();
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        Task oldTask = this.tasks.get(rowIndex);
        Task newTask = Task.newTask(oldTask.getId(), oldTask.getIdProject(), 
                       oldTask.getName(), oldTask.getDescription(), oldTask.getNote(),
                       (boolean) aValue, oldTask.getDeadline(), oldTask.getCreateDate(), 
                       oldTask.getUpdateDate());
        this.tasks.set(rowIndex, newTask);
    }
    
    

    public String[] getColumns() {
        return columns;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
        
}//class
