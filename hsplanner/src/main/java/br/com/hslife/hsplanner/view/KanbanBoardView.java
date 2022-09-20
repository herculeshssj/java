package br.com.hslife.hsplanner.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import br.com.hslife.hsplanner.vo.CardVO;
import br.com.hslife.hsplanner.vo.ProjectVO;

@ManagedBean
@SessionScoped
public class KanbanBoardView implements Serializable{

    // Mock
    private List<ProjectVO> listProjects = new ArrayList<>();
    private ProjectVO project = new ProjectVO();

    // Mock
    private List<CardVO> listCards = new ArrayList<>();
    private CardVO card = new CardVO();

    // Actions
    public void newProject() {
        Map<String,Object> options = new HashMap<>();
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("modal", true);
        options.put("width", 320);
        options.put("height", 240);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        options.put("headerElement", "customheader");
        PrimeFaces.current().dialog().openDynamic("newProject", options, null);
    }
    
    public void saveProject() {
        PrimeFaces.current().dialog().closeDynamic(project);
    }

    public void onSavingProject(SelectEvent<ProjectVO> event) {
        ProjectVO project = event.getObject();

        listProjects.add(project);
        this.project = new ProjectVO();

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Project", "Project created!"));
    }

    public String getTitle() {
        return "HSplanner - Gestão ágil e inteligente";
    }

    public List<CardVO> getListCards() {
        return listCards;
    }

    public void setListCards(List<CardVO> listCards) {
        this.listCards = listCards;
    }

    public CardVO getCard() {
        return card;
    }

    public void setCard(CardVO card) {
        this.card = card;
    }

    public List<ProjectVO> getListProjects() {
        return listProjects;
    }

    public void setListProjects(List<ProjectVO> listProjects) {
        this.listProjects = listProjects;
    }

    public ProjectVO getProject() {
        return project;
    }

    public void setProject(ProjectVO project) {
        this.project = project;
    }
}
