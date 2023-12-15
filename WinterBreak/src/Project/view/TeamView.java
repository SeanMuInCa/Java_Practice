package Project.view;

import Project.domain.Employee;
import Project.domain.Programmer;
import Project.service.NameListService;
import Project.service.TeamException;
import Project.service.TeamService;

/**
 * Purpose:             Project.view<br />
 * Data Submitted:      2023/12/15 <br />
 * Assignment Number:    Project.view<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.view <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TeamView
{
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();
    public void enterMainMenu(){
        boolean flag = true;
        char key = 0;
        do
        {
            if(key != '1'){
                listAllEmployees();
            }
            System.out.println("1- team list  2-add member  3- remove member  4- quit");
            key = TSUtility.readMenuSelection();
            System.out.println();
            switch (key)
            {
                case '1':
                    listTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    removeMember();
                    break;
                case '4':
                    System.out.println("are you sure(y/n): ");
                    char yn = TSUtility.readConfirmSelection();
                    if(yn == 'y'){
                        flag = false;
                    }
                    break;
                default:
                    System.out.println("Invalid selection");
                    break;
            }
        }while (flag);
    }

    private void listAllEmployees(){
        System.out.println("\n----Welcome to our system----");
        Employee[] emps = listSvc.getAllEmployees();
        if(emps.length == 0){
            System.out.println("no record");
        }else{
            System.out.println("ID\tname\t\tage\tsalary\t\tposition\t\tstatus\t\tbonus\t\tstock\t\tequipment");
        }
        for (int i = 0; i < emps.length; i++)
        {
            System.out.println(" " + emps[i]);
        }
        System.out.println("---------------------");
    }
    private void listTeam(){
        System.out.println("\n----members list----");
        Programmer[] team = teamSvc.getTeam();
        if(team.length == 0){
            System.out.println("no record");
        }else{
            System.out.println("TID/ID\tname\t\tage\tsalary\t\tposition\t\tbonus\t\tstock");
        }
        for (int i = 0; i < team.length; i++)
        {
            System.out.println(" " + team[i].getDetails());
        }
        System.out.println("----------------------");
    }

    private void addMember(){
        System.out.println("----add member----");
        System.out.println("input member id you want to add ");
        int id = TSUtility.readInt();
        try
        {
            Employee e = listSvc.getEmployee(id);
            teamSvc.addMember(e);
            System.out.println("add success");
        }catch (TeamException e){
            System.out.println("failed to add " + e.getMessage());
        }
        TSUtility.readReturn();
    }

    private void removeMember(){
        System.out.println("----remove member----");
        System.out.println("input id you want to remove ");
        int id = TSUtility.readInt();
        try
        {
            Employee e = listSvc.getEmployee(id);
            teamSvc.removeMember(id);
            System.out.println("remove success");
        }catch (TeamException e){
            System.out.println("failed to remove " + e.getMessage());
        }
        TSUtility.readReturn();
    }

    public static void main(String[] args)
    {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }

}
