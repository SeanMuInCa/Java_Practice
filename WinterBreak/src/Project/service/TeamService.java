package Project.service;

import Project.domain.Architect;
import Project.domain.Designer;
import Project.domain.Employee;
import Project.domain.Programmer;

/**
 * Purpose:             Project.service<br />
 * Data Submitted:      2023/12/14 <br />
 * Assignment Number:    Project.service<br />
 * Course Name:         COSC601  <br />
 * Instructor:          George Ding  <br />
 * File Path:          Project.service <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class TeamService
{
    private static int counter = 1;
    private final int MAX_MEMBER = 5;
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;


    public Programmer[] getTeam()
    {
        Programmer[] temp = new Programmer[total];
        System.arraycopy(team, 0, temp, 0, total);
        return temp;
    }

    public void addMember(Employee e) throws TeamException
    {
        for (Employee employee : team){
            if (total >= MAX_MEMBER){
                throw new TeamException("The team is full");
            }
            if(!(e instanceof Programmer)){
                throw new TeamException("This guy is not a Programmer");
            }
            Programmer p = (Programmer) e;
            if(p.getStatus() == Status.VOCATION)
            {
                throw new TeamException("This guy is on vacation");
            }
            if(p.getStatus() == Status.BUSY)
            {
                throw new TeamException("This guy is already in a team");
            }
            /*这里有逻辑错误，当队伍中已有2个设计师，此时再加入一个架构师，就会抛出异常
            if(p instanceof Architect && isArchitectExist(p)){
                throw new TeamException("Only one Architect allowed");
            }
            if(p instanceof Designer && isDesignerMoreThanTwo(p)){
                throw new TeamException("Only two Designer allowed");
            }
            if(isProgrammerMoreThanThree(p)){
                throw new TeamException("Only three Programmer allowed");
            }*/
            int archNum = 0, desNum = 0, proNum = 0;
            for (Employee em : team){
                if(em instanceof Architect){
                    archNum++;
                }
                else if(em instanceof Designer){
                    desNum++;
                }
                else if(em instanceof Programmer){
                    proNum++;
                }
            }
            if(p instanceof Architect){
                if(archNum >= 1){
                    throw new TeamException("Only one Architect allowed");
                }
            } else if (p instanceof Designer)
            {
                if(desNum >= 2){
                    throw new TeamException("Only two Designer allowed");
                }
            }else{
                if(proNum >= 3){
                    throw new TeamException("Only three Programmer allowed");
                }
            }
            team[total] = p;
            total++;
            p.setMemberId(counter++);
            p.setStatus(Status.BUSY);
            break;
        }
    }

    public void removeMember(int memberId) throws TeamException
    {
        int i = 0;
        for (; i < total; i++)
        {
            if(team[i].getMemberId() == memberId){
                team[i].setStatus(Status.FREE);
                break;//避免了for 里有if还有for的情况
            }
        }
        if(i == total){
            throw new TeamException("no such member");
        }
        //没有被抛出，说明找到了，这里调整数组，删除该删除的，后面的往前挪
        for (int j = total - 1; j >= i;j--)
        {
            team[j - 1] = team[j];
        }
        team[total - 1] = null;
        total--;
    }
}
