/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers.services;

import controllers.GeneralController;
import controllers.InterfaceController;
import java.util.ArrayList;
import models.Job;
import java.util.List;
import org.hibernate.SessionFactory;

/**
 *
 * @author Ignatius
 */
public class JobService {
    private final InterfaceController<Job> iController;

    public JobService(SessionFactory sessionFactory) {
        this.iController = new GeneralController(sessionFactory, Job.class);
    }
    
    public boolean saveOrUpdate(String jobId, String jobName, String minSalary, String maxSalary){
        Job job = new Job(jobId, jobName, Integer.parseInt(minSalary), Integer.parseInt(maxSalary));
        return iController.doDDL(job, true);
    }
    
    public boolean delete(String jobId){
        Job job = new Job(jobId);
        return iController.doDDL(job, false);
    }
    
    public List<Job> getAll(){
        return iController.doDML(false, null, null);
    }
    
    public List<Job> search(String category, String key){
        return iController.doDML(true, category, key);
    }
    
    public Job getById(String jobId){
        return iController.getById(jobId);
    }
    
    public List<Object[]> getAllData(List<Job> jobs){
        List<Object[]> datas = new ArrayList<>();
        int i = 1;
        for (Job job : jobs) {
            Object[] data = new Object[5];
            data[0]=i;
            data[1]=job.getJobId();
            data[2]=job.getJobTitle();
            data[3]=job.getMinSalary();
            data[4]=job.getMaxSalary();
            i++;
            datas.add(data);
        }
        return datas;
    }
}
