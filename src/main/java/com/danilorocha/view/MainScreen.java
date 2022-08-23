/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.danilorocha.view;

import com.danilorocha.controllers.ProjectController;
import com.danilorocha.controllers.TaskController;
import com.danilorocha.entities.Project;
import com.danilorocha.entities.Task;
import com.danilorocha.exception.MyException;
import com.danilorocha.util.ButtonColumnCellRenderer;
import com.danilorocha.util.DeadlineColumnCellRenderer;
import com.danilorocha.util.TaskTableModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import static com.danilorocha.util.UtilView.messageDialog;

/**
 * @author danilo
 */
public class MainScreen extends javax.swing.JFrame {

    private final ProjectController projectController;
    private final TaskController taskController;
    private final DefaultListModel projectsModel;
    private TaskTableModel taskTableModel;

    /**
     * Creates new form MainScreen
     */
    public MainScreen() {
        initComponents();
        projectController = new ProjectController();
        taskController = new TaskController();
        projectsModel = new DefaultListModel();
        loadProjects();
        selectFirstProject();
        decorateTableTask();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPanelTasks = new javax.swing.JScrollPane();
        tableTasks = new javax.swing.JTable();
        JPanel panelContents = new JPanel();
        JPanel panelTitleBar = new JPanel();
        JLabel labelTitle = new JLabel();
        JLabel labelSubtitle = new JLabel();
        JLabel labelIcon = new JLabel();
        JPanel panelProjects = new JPanel();
        JLabel labelProjectsTitle = new JLabel();
        JLabel jLabelProjectIconAdd = new JLabel();
        JLabel jLabelProjectIconEdit = new JLabel();
        JLabel jLabelProjectIconDelele = new JLabel();
        JPanel panelTasks = new JPanel();
        JLabel labelTasksTitle = new JLabel();
        // Variables declaration - do not modify//GEN-BEGIN:variables
        JLabel jlabelTasksIconAdd = new JLabel();
        JPanel panelProjectsList = new JPanel();
        JScrollPane scrollPanelProjects = new JScrollPane();
        listProjects = new javax.swing.JList<>();
        panelContentsTask = new javax.swing.JPanel();
        panelEmptyList = new javax.swing.JPanel();
        JLabel labelEmptyListIcon = new JLabel();
        JLabel labelEmptyListTitle = new JLabel();
        JLabel labelEmptyListSubtitle = new JLabel();

        scrollPanelTasks.setBackground(java.awt.Color.white);

        tableTasks.setBackground(java.awt.Color.white);
        tableTasks.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        tableTasks.setForeground(java.awt.Color.black);
        tableTasks.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Nome", "Descrição", "Prazo", "Tarefa Concluída"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Boolean.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tableTasks.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        tableTasks.setFocusable(false);
        tableTasks.setGridColor(java.awt.Color.white);
        tableTasks.setRowHeight(40);
        tableTasks.setSelectionBackground(new java.awt.Color(204, 255, 204));
        tableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableTasks.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tableTasks.setShowGrid(false);
        tableTasks.setShowHorizontalLines(true);
        tableTasks.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableTasksMouseClicked(evt);
            }
        });
        scrollPanelTasks.setViewportView(tableTasks);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(java.awt.Color.black);
        setMinimumSize(new java.awt.Dimension(600, 700));

        panelContents.setBackground(java.awt.Color.white);
        panelContents.setName(""); // NOI18N

        panelTitleBar.setBackground(new java.awt.Color(0, 153, 102));
        panelTitleBar.setBorder(new javax.swing.border.MatteBorder(null));

        labelTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 36)); // NOI18N
        labelTitle.setForeground(new java.awt.Color(255, 255, 255));
        labelTitle.setText("Tarefas");

        labelSubtitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 0, 12)); // NOI18N
        labelSubtitle.setForeground(new java.awt.Color(255, 255, 255));
        labelSubtitle.setText("Anote tudo, não esqueça nada!");

        labelIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/tick.png"))); // NOI18N

        javax.swing.GroupLayout panelTitleBarLayout = new javax.swing.GroupLayout(panelTitleBar);
        panelTitleBar.setLayout(panelTitleBarLayout);
        panelTitleBarLayout.setHorizontalGroup(
            panelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleBarLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(labelIcon)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelSubtitle)
                    .addComponent(labelTitle))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelTitleBarLayout.setVerticalGroup(
            panelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTitleBarLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(panelTitleBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(labelIcon)
                    .addGroup(panelTitleBarLayout.createSequentialGroup()
                        .addComponent(labelTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelSubtitle)))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        panelProjects.setBackground(java.awt.Color.white);
        panelProjects.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelProjects.setToolTipText("");

        labelProjectsTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        labelProjectsTitle.setForeground(new java.awt.Color(0, 153, 102));
        labelProjectsTitle.setText("Projetos");

        jLabelProjectIconAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectIconAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jLabelProjectIconAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectIconAddMouseClicked(evt);
            }
        });

        jLabelProjectIconEdit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectIconEdit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        jLabelProjectIconEdit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectIconEditMouseClicked(evt);
            }
        });

        jLabelProjectIconDelele.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelProjectIconDelele.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        jLabelProjectIconDelele.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelProjectIconDeleleMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelProjectsLayout = new javax.swing.GroupLayout(panelProjects);
        panelProjects.setLayout(panelProjectsLayout);
        panelProjectsLayout.setHorizontalGroup(
            panelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(jLabelProjectIconAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProjectIconEdit, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelProjectIconDelele, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelProjectsLayout.setVerticalGroup(
            panelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjectsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelProjectIconDelele, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelProjectsLayout.createSequentialGroup()
                        .addGroup(panelProjectsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(labelProjectsTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelProjectIconEdit, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabelProjectIconAdd, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        panelTasks.setBackground(java.awt.Color.white);
        panelTasks.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        labelTasksTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        labelTasksTitle.setForeground(new java.awt.Color(0, 153, 102));
        labelTasksTitle.setText("Tarefas");

        jlabelTasksIconAdd.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlabelTasksIconAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        jlabelTasksIconAdd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelTasksIconAddMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelTasksLayout = new javax.swing.GroupLayout(panelTasks);
        panelTasks.setLayout(panelTasksLayout);
        panelTasksLayout.setHorizontalGroup(
            panelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelTasksLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(labelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlabelTasksIconAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelTasksLayout.setVerticalGroup(
            panelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelTasksLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelTasksLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelTasksTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabelTasksIconAdd, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        panelProjectsList.setBackground(java.awt.Color.white);
        panelProjectsList.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        listProjects.setBackground(new java.awt.Color(255, 255, 255));
        listProjects.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 18)); // NOI18N
        listProjects.setForeground(new java.awt.Color(51, 51, 51));
        listProjects.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        listProjects.setFixedCellHeight(40);
        listProjects.setSelectionBackground(new java.awt.Color(0, 153, 102));
        listProjects.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                listProjectsMouseClicked(evt);
            }
        });
        scrollPanelProjects.setViewportView(listProjects);

        javax.swing.GroupLayout panelProjectsListLayout = new javax.swing.GroupLayout(panelProjectsList);
        panelProjectsList.setLayout(panelProjectsListLayout);
        panelProjectsListLayout.setHorizontalGroup(
            panelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelProjectsListLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPanelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelProjectsListLayout.setVerticalGroup(
            panelProjectsListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelProjectsListLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(scrollPanelProjects)
                .addContainerGap())
        );

        panelContentsTask.setBackground(java.awt.Color.white);
        panelContentsTask.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        panelContentsTask.setLayout(new java.awt.BorderLayout());

        panelEmptyList.setBackground(new java.awt.Color(255, 255, 255));

        labelEmptyListIcon.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmptyListIcon.setIcon(new javax.swing.ImageIcon(getClass().getResource("/lists.png"))); // NOI18N

        labelEmptyListTitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 14)); // NOI18N
        labelEmptyListTitle.setForeground(new java.awt.Color(0, 153, 102));
        labelEmptyListTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmptyListTitle.setText("Não há tarefas no momento :D");

        labelEmptyListSubtitle.setFont(new java.awt.Font("DejaVu Sans Condensed", 1, 12)); // NOI18N
        labelEmptyListSubtitle.setForeground(new java.awt.Color(153, 153, 153));
        labelEmptyListSubtitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelEmptyListSubtitle.setText("Click no botão de \"+\" para adicionar nova tarefa");

        javax.swing.GroupLayout panelEmptyListLayout = new javax.swing.GroupLayout(panelEmptyList);
        panelEmptyList.setLayout(panelEmptyListLayout);
        panelEmptyListLayout.setHorizontalGroup(
            panelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelEmptyListTitle, javax.swing.GroupLayout.DEFAULT_SIZE, 860, Short.MAX_VALUE)
            .addComponent(labelEmptyListSubtitle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(labelEmptyListIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        panelEmptyListLayout.setVerticalGroup(
            panelEmptyListLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEmptyListLayout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(labelEmptyListIcon)
                .addGap(18, 18, 18)
                .addComponent(labelEmptyListTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelEmptyListSubtitle)
                .addContainerGap(124, Short.MAX_VALUE))
        );

        panelContentsTask.add(panelEmptyList, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout panelContentsLayout = new javax.swing.GroupLayout(panelContents);
        panelContents.setLayout(panelContentsLayout);
        panelContentsLayout.setHorizontalGroup(
            panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentsLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelTitleBar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(panelContentsLayout.createSequentialGroup()
                        .addGroup(panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(panelProjectsList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(9, 9, 9)
                        .addGroup(panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(panelTasks, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(panelContentsTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        panelContentsLayout.setVerticalGroup(
            panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelContentsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelTitleBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProjects, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelTasks, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelContentsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelProjectsList, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelContentsTask, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panelContents, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelProjectIconAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectIconAddMouseClicked
        // TODO add your handling code here:
        ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
        projectDialogScreen.setVisible(true);
        int previousProjectListSize = projectsModel.getSize();

        /*Atualiza a lista de projetos após a janela de cadastro de projeto for fechada*/
        projectDialogScreen.addWindowListener(new WindowAdapter() {
            final int selectedIndex = listProjects.getSelectedIndex();
            @Override
            public void windowClosed(WindowEvent we) {
                loadProjects();
                int laterProjectListSize = projectsModel.getSize();

                if (previousProjectListSize != laterProjectListSize) {
                    listProjects.setSelectedIndex(listProjects.getLastVisibleIndex());
                } else {
                    listProjects.setSelectedIndex(selectedIndex);
                }
                loadTasks(Objects.requireNonNull(getProjectUI()));
            }
        });
    }//GEN-LAST:event_jLabelProjectIconAddMouseClicked

    private void listProjectsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_listProjectsMouseClicked
        // TODO add your handling code here:
        listProjects.setSelectionForeground(Color.WHITE);
        loadTasks(Objects.requireNonNull(getProjectUI()));
    }//GEN-LAST:event_listProjectsMouseClicked

    private void jLabelTasksIconAddMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_JlabelTasksIconAddMouseClicked
        // TODO add your handling code here:
        TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        if (Objects.nonNull(getProjectUI())) {
            taskDialogScreen.setProject(getProjectUI());
            taskDialogScreen.setVisible(true);
        } else {
            messageDialog(rootPane, "Selecione um projeto para cadastrar a tarefa");
        }

        /*Atualiza a lista de tarefas após a janela de cadastro de tarefa for
        fechada*/
        taskDialogScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadTasks(getProjectUI());
            }
        });
    }//GEN-LAST:event_JlabelTasksIconAddMouseClicked

    private void tableTasksMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableTasksMouseClicked
        // TODO add your handling code here:
        int rowIndex = tableTasks.rowAtPoint(evt.getPoint());
        int colIndex = tableTasks.columnAtPoint(evt.getPoint());

        switch (colIndex) {
            case 4 -> taskIsCompleted(rowIndex);
            case 5 -> editTask(rowIndex);
            case 6 -> deleteTask(rowIndex);
        }
    }//GEN-LAST:event_tableTasksMouseClicked

    private void jLabelProjectIconEditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectIconEditMouseClicked
        // TODO add your handling code here:
        if (Objects.nonNull(getProjectUI())) {
            ProjectDialogScreen projectDialogScreen = new ProjectDialogScreen(this, rootPaneCheckingEnabled);
            projectDialogScreen.setProject(getProjectUI());
            projectDialogScreen.setVisible(true);
            projectDialogScreen.addWindowListener(new WindowAdapter() {
                final int selectedIndex = listProjects.getSelectedIndex();
                @Override
                public void windowClosed(WindowEvent e) {
                    loadProjects();
                    listProjects.setSelectedIndex(selectedIndex);
                }
            });
        } else {
            messageDialog(rootPane, "Selecione um projeto para editá-lo");
        }
    }//GEN-LAST:event_jLabelProjectIconEditMouseClicked

    private void jLabelProjectIconDeleleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelProjectIconDeleleMouseClicked
        // TODO add your handling code here:
        if (Objects.nonNull(getProjectUI())) {
            int confirm = JOptionPane.showConfirmDialog(rootPane, "Excluir o projeto " + getProjectUI().getName());
            if (confirm == 0) {
                int selectedIndex = listProjects.getSelectedIndex();
                projectController.removeById(getProjectUI().getId());
                loadProjects();
                if (selectedIndex == listProjects.getFirstVisibleIndex()) {
                    listProjects.setSelectedIndex(listProjects.getFirstVisibleIndex());
                    listProjects.setSelectionForeground(Color.WHITE);
                } else if (selectedIndex - 1 == listProjects.getLastVisibleIndex()) {
                    listProjects.setSelectedIndex(listProjects.getLastVisibleIndex());
                    listProjects.setSelectionForeground(Color.WHITE);
                } else {
                    listProjects.setSelectedIndex(selectedIndex);
                    listProjects.setSelectionForeground(Color.WHITE);
                }
                loadTasks(getProjectUI());
            }
        } else {
            messageDialog(rootPane, "Selecione um projeto para excluí-lo");
        }
    }//GEN-LAST:event_jLabelProjectIconDeleleMouseClicked

    private void taskIsCompleted(int rowIndex) {
        Task completedTask = taskTableModel.getTasks().get(rowIndex);
        taskController.update(completedTask);
    }

    private void editTask(int rowIndex) {
        TaskDialogScreen taskDialogScreen = new TaskDialogScreen(this, rootPaneCheckingEnabled);
        Task task = taskTableModel.getTasks().get(rowIndex);
        taskDialogScreen.setTask(task);
        taskDialogScreen.setVisible(true);

        taskDialogScreen.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                loadTasks(Objects.requireNonNull(getProjectUI()));
            }
        });
    }

    private void deleteTask(int rowIndex) {
        Task task = taskTableModel.getTasks().get(rowIndex);
        int confirm = JOptionPane.showConfirmDialog(rootPane, "Excluir a tarefa " + task.getName());
        if (confirm == 0) {
            taskController.removeById(task.getId());
            loadTasks(Objects.requireNonNull(getProjectUI()));
        }
    }

    private void loadProjects() {
        Optional<List<Project>> optionalProjects = projectController.getAll();
        projectsModel.clear();
        optionalProjects.orElseThrow(()
                -> new MyException(rootPane, "Não foi possível listar os projetos")).forEach(projectsModel::addElement);
        listProjects.setModel(projectsModel);
    }

    private void loadTasks(Project project) {
        List<Task> tasks = taskController.getAll(project.getId());
        taskTableModel = new TaskTableModel();
        tableTasks.setModel(taskTableModel);
        taskTableModel.setTasks(tasks);
        decorateTableTask();
        changeTasksPane();
    }
    
    private void selectFirstProject() {
        listProjects.setSelectedIndex(0);
        listProjects.setSelectionForeground(Color.WHITE);
        loadTasks(Objects.requireNonNull(getProjectUI()));
    }

    private Project getProjectUI() {
        int index = listProjects.getSelectedIndex();
        if (index < 0)
            return null;
        return (Project) projectsModel.get(index);
    }

    private void changeTasksPane() {
        boolean isEmptyTasks = taskTableModel.getTasks().isEmpty();

        if (!isEmptyTasks && Objects.nonNull(getProjectUI())) {
            if (panelEmptyList.isVisible())
                panelEmptyList.setVisible(false);

            panelContentsTask.add(scrollPanelTasks);
            scrollPanelTasks.setVisible(true);
            scrollPanelTasks.setSize(panelContentsTask.getWidth(), panelContentsTask.getHeight());
        } else {
            if (scrollPanelTasks.isVisible()) {
                scrollPanelTasks.setVisible(false);
                panelContentsTask.remove(scrollPanelTasks);
            }

            panelContentsTask.add(panelEmptyList);
            panelEmptyList.setVisible(true);
            panelEmptyList.setSize(panelContentsTask.getWidth(), panelContentsTask.getHeight());
        }//if
    }//showTasks
    
    private void decorateTableTask() {
        tableTasks.getTableHeader().setFont(new Font("DejaVu Sans Condensed", Font.BOLD, 14));
        tableTasks.getTableHeader().setBackground(new Color(0, 153, 102));
        tableTasks.getTableHeader().setForeground(Color.WHITE);
        tableTasks.setAutoCreateRowSorter(true);
        if (taskTableModel != null) {
            tableTasks.getColumnModel().getColumn(2).setCellRenderer(new DeadlineColumnCellRenderer());
            tableTasks.getColumnModel().getColumn(5).setCellRenderer(new ButtonColumnCellRenderer("edit"));
            tableTasks.getColumnModel().getColumn(6).setCellRenderer(new ButtonColumnCellRenderer("delete"));
        }
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Java swing".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainScreen().setVisible(true);
            }
        });

    }//main

    private javax.swing.JList<String> listProjects;
    private javax.swing.JPanel panelContentsTask;
    private javax.swing.JPanel panelEmptyList;
    private javax.swing.JScrollPane scrollPanelTasks;
    private javax.swing.JTable tableTasks;
    // End of variables declaration//GEN-END:variables

}//class
