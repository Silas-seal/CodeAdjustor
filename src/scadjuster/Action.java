/*
 * Main App Functionalities
 */
package scadjuster;

/**
 *
 * @author Seumx Plus
 */

import java.io.*;

public class Action implements smx.jfx.util.SRunnable {
    
    private double progress=0;
    private String name,wat,wit;
    private Thread th;
    
    protected DataInputStream din;
    protected FileWriter wrt;
    
    private File[] fils;
    
    /**
     * replace a single file
     * @param ori
     * @param what
     * @param with
     * @throws IOException 
     */
    @SuppressWarnings("ConvertToTryWithResources")
    public void replace(File ori,String what,String with) throws Exception 
    {
        //Read ori file
        String oriu="";
        din=new DataInputStream(new FileInputStream(ori));
        
        while(din.available()>0) {
            oriu+=din.readLine()+"\n";
        }
        
        oriu=new SCAdjuster().IgnoreDS(java.util.regex.Matcher.quoteReplacement(oriu.replace(what, with)));
        
        //Write dis file with arg String
        wrt=new FileWriter(ori);
        wrt.write(oriu); wrt.flush(); wrt.close();
        
        /*Done*/ Thread.sleep(50);
    }
    
    /**
     * Replacing many Files
     * @param files
     * @param what
     * @param with 
     * @throws java.io.IOException 
     */
    public void replaceAll(File[] files,String what,String with) throws Exception 
    {
        //read and replace 
        double pi=0,l=files.length-1;
        for(File fl:files)
        {
            replace(fl,what,with); setProgress(pi/l);
            
            System.out.println(progress);
            
            pi++;
        }
    }
    
    /**
     * Set Data to be replaced an files!
     * @param files
     * @param what
     * @param with 
     */
    public void setData(File[] files,String what,String with)
    {
        fils=files; wat=what; wit=with;
    }
    
    @Override
    public void setProgress(double di) 
    {
        this.progress=di;
    }
    
    @Override
    public void setName(String name) 
    {
        this.name=name;
    }
    
    /**
     * Returns progress of many files
     * @return 
     */
    @Override
    public double getProgress()
    {
        return this.progress;
    }
    
    @Override
    public String getName() 
    {
        return name;
    }
    
    @Override
    public void run() 
    {
        try {
        replaceAll(fils,wat,wit);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    
    @Override
    public void start()
    {
        th=new Thread(this); th.start();
    }
    
}
