package TestFileAndIO1;

import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Purpose:             TestFileAndIO1<br />
 * Data Submitted:      2024/1/25 <br />
 * Assignment Number:    TestFileAndIO1<br />
 * Course Name:         COSC602  <br />
 * Instructor:          George Ding  <br />
 * File Path:          TestFileAndIO1 <br />
 *
 * @author Zhenghua Mu
 * @version 1.0.0
 */
public class LoadCSV
{
    @Test
    public void test1(){
        List<Employee> list = new ArrayList<>();
        File f = new File("D:\\employees.csv");
        FileReader fr = null;
        FileWriter fw = null;
        BufferedReader br = null;
        BufferedWriter bw = null;
        try
        {

            fr = new FileReader(f);
            br = new BufferedReader(fr);

            String oneLineData;
            String res = "";
            br.readLine();
            while ((oneLineData = br.readLine()) != null)
            {
                Employee e = new Employee();
                String[] result = oneLineData.split(",\\s*(?![^\"]*\"\\,)");
                e.employee_id = Integer.valueOf(result[0]);
                e.f_name = result[1];
                e.l_name = result[2];
                e.email = result[3];
                e.number = result[4];
                e.hire_date = result[5];
                e.job_id = result[6];
                e.salary = Double.valueOf(result[7]);
                e.commission_pct = Double.valueOf(result[8]);
                e.manager_id = Integer.valueOf(result[9]);
                e.department_id = Integer.valueOf(result[10]);
                list.add(e);
            }
            System.out.println(list.size());

        }catch (IOException e)
        {
            e.printStackTrace();
        }
    }
    class Employee
    {
        int employee_id;
        String f_name;
        String l_name;
        String email;
        String number;
        String hire_date;
        String job_id;
        double salary;
        double commission_pct;
        int manager_id;
        int department_id;

        public Employee()
        {
        }

        public Employee(int employee_id, String f_name, String l_name, String email, String number, String hire_date, String job_id, double salary, double commission_pct, int manager_id, int department_id)
        {
            this.employee_id = employee_id;
            this.f_name = f_name;
            this.l_name = l_name;
            this.email = email;
            this.number = number;
            this.hire_date = hire_date;
            this.job_id = job_id;
            this.salary = salary;
            this.commission_pct = commission_pct;
            this.manager_id = manager_id;
            this.department_id = department_id;
        }

        @Override
        public String toString()
        {
            return "Employee{" +
                    "employee_id=" + employee_id +
                    ", l_name='" + l_name + '\'' +
                    '}';
        }
    }
}
