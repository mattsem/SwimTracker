/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimtrack;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.*;

/**
 *
 * @author Matt
 */
public class FileManagement {
    private Map<String, Map> EventData = new HashMap<>();
    
    
    private Map<Long, Time> Fr50Scy = new HashMap<>();
    private Map<Long, Time> Fr100Scy = new HashMap<>();
    private Map<Long, Time> Fr200Scy = new HashMap<>();
    private Map<Long, Time> Fr500Scy = new HashMap<>();
    private Map<Long, Time> Fl50Scy = new HashMap<>();
    private Map<Long, Time> Fl100Scy = new HashMap<>();
    private Map<Long, Time> Fl200Scy = new HashMap<>();
    private Map<Long, Time> Fr1000Scy = new HashMap<>();
    private Map<Long, Time> Fr1650Scy = new HashMap<>();
    private Map<Long, Time> Br50Scy = new HashMap<>();
    private Map<Long, Time> Br100Scy = new HashMap<>();
    private Map<Long, Time> Br200Scy = new HashMap<>();
    private Map<Long, Time> Bk50Scy = new HashMap<>();
    private Map<Long, Time> Bk100Scy = new HashMap<>();
    private Map<Long, Time> Bk200Scy = new HashMap<>();
    private Map<Long, Time> Fr50Lcm = new HashMap<>();
    private Map<Long, Time> Fr100Lcm = new HashMap<>();
    private Map<Long, Time> Fr200Lcm = new HashMap<>();
    private Map<Long, Time> Fl50Lcm = new HashMap<>();
    private Map<Long, Time> Fl100Lcm = new HashMap<>();
    private Map<Long, Time> Fl200Lcm = new HashMap<>();
    private Map<Long, Time> Br50Lcm = new HashMap<>();
    private Map<Long, Time> Br100Lcm = new HashMap<>();
    private Map<Long, Time> Br200Lcm = new HashMap<>();
    private Map<Long, Time> Bk50Lcm = new HashMap<>();
    private Map<Long, Time> Bk100Lcm = new HashMap<>();
    private Map<Long, Time> Bk200Lcm = new HashMap<>();
    private Map<Long, Time> Im100Scy = new HashMap<>();
    private Map<Long, Time> Im200Scy = new HashMap<>();
    
    private Map<Long, Time> Im200Lcm = new HashMap<>();
    private Map<Long, Time> Im400Scy = new HashMap<>();
    private Map<Long, Time> Im400Lcm = new HashMap<>();
    private Map<Long, Time> Fr400Lcm = new HashMap<>();
    private Map<Long, Time> Fr1500Lcm = new HashMap<>();
    
    
    
    public FileManagement() throws FileNotFoundException, ParseException{
        dataUpload();
        condenseMaps();
    }
    
    public void condenseMaps(){
        EventData.put("50 Free", Fr50Scy);
        EventData.put("100 Free", Fr100Scy);
        EventData.put("200 Free", Fr200Scy);
        EventData.put("500 Free", Fr500Scy);
        EventData.put("50 Fly", Fl50Scy);
        EventData.put("100 Fly", Fl100Scy);
        EventData.put("200 Fly", Fl200Scy);
        EventData.put("1000 Free", Fr1000Scy);
        EventData.put("1650 Free", Fr1650Scy);
        EventData.put("50 Breast", Br50Scy);
        EventData.put("100 Breast", Br100Scy);
        EventData.put("200 Breast", Br200Scy);
        EventData.put("50 Back", Bk50Scy);
        EventData.put("100 Back", Bk100Scy);
        EventData.put("200 Back", Bk200Scy);
        EventData.put("100 IM", Im100Scy);
        EventData.put("200 IM", Im200Scy);
        //EventData.put("400 IM", Im400Scy);
        
        
//        EventData.put("50 Free", Fr50Lcm);
//        EventData.put("100 Free", Fr100Lcm);
//        EventData.put("200 Free", Fr200Lcm);
//        EventData.put("50 Fly", Fl50Lcm);
//        EventData.put("100 Fly", Fl100Lcm);
//        EventData.put("50 Free", Fl200Lcm);
//        EventData.put("100 Free", Br50Lcm);
//        EventData.put("200 Free", Br100Lcm);
//        EventData.put("500 Free", Br200Lcm);
//        EventData.put("50 Fly", Bk50Lcm);
//        EventData.put("100 Fly", Bk100Lcm);
//        EventData.put("200 Free", Bk200Lcm);
//        EventData.put("100 Free", Im100Scy);
//        EventData.put("50 Free", Im200Scy);
//        EventData.put("100 Free", Im200Lcm);
//        EventData.put("100 Free", Im400Scy);
//        EventData.put("100 Free", Im400Lcm);
//        EventData.put("100 Free", Fr400Lcm);
//        EventData.put("100 Free", Fr1500Lcm);

        
        
    }
    
    
    public void dataUpload() throws FileNotFoundException, ParseException{
        File uploadedData = new File("C:\\Users\\Matt\\Documents\\NetBeansProjects\\SwimTracker\\Times For Matt Seminatore (1).csv");
        FileReader f = new FileReader(uploadedData);
        Scanner sc = new Scanner(f);
        
        if(sc.hasNextLine()){
            sc.nextLine();
        }else{
            System.out.println("file upload error");
        }
        
        
        while(sc.hasNextLine()){
            parse(sc.nextLine());    
        }
        
        
         
    }
    
    
    
    public void parse(String line) throws ParseException{
        String[] segmented = line.split(",");
        
        Time t = new Time(segmented[1]);
        
        
//        
//        int year =  Integer.parseInt(segmented[9].split("/")[2]);
//        
//        int month = Integer.parseInt(segmented[9].split("/")[0]);
//        int day = Integer.parseInt(segmented[9].split("/")[1]);
//        
//        Date date = new Date(year, month - 1, day);
        
        SimpleDateFormat sd = new SimpleDateFormat("MM/dd/yyyy");
        Date ad = sd.parse(segmented[9]);
        
        long d = ad.getTime();
        
        
        if(segmented[0].equalsIgnoreCase("50 fr")){
            Fr50Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("100 fr")){
            Fr100Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("200 fr")){
            Fr200Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("500 fr")){
            Fr500Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("1000 fr")){
            Fr1000Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("1650 fr")){
            Fr1650Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("50 bk")){
            Bk50Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("100 bk")){
            Bk100Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("200 bk")){
            Bk200Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("50 br")){
            Br50Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("100 br")){
            Br100Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("200 br")){
            Br200Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("50 fl")){
            Fl50Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("100 fl")){
            Fl100Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("200 fl")){
            Fl200Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("100 IM")){
            Im100Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("200 IM")){
            Im200Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("400 IM")){
            Im400Scy.put(d, t);
        }else if(segmented[0].equalsIgnoreCase("400 FR")){
            Fr400Lcm.put(d, t);
            
        }else if(segmented[0].equalsIgnoreCase("1500 Fr")){
            Fr1500Lcm.put(d, t);    
        }else{
            System.out.println(segmented[0]);
            System.out.println("unknown event");
        }
        
        
        
    }
    
    
    
    
    public Map<String,Map> getEventData(){
        return EventData;
    }

    public Map<Long, Time> getFr50Scy() {
        return Fr50Scy;
    }

    public void setFr50Scy(Map<Long, Time> Fr50Scy) {
        this.Fr50Scy = Fr50Scy;
    }

    public Map<Long, Time> getFr100Scy() {
        return Fr100Scy;
    }

    public void setFr100Scy(Map<Long, Time> Fr100Scy) {
        this.Fr100Scy = Fr100Scy;
    }

    public Map<Long, Time> getFr200Scy() {
        return Fr200Scy;
    }

    public void setFr200Scy(Map<Long, Time> Fr200Scy) {
        this.Fr200Scy = Fr200Scy;
    }

    public Map<Long, Time> getFr500Scy() {
        return Fr500Scy;
    }

    public void setFr500Scy(Map<Long, Time> Fr500Scy) {
        this.Fr500Scy = Fr500Scy;
    }

    public Map<Long, Time> getFl50Scy() {
        return Fl50Scy;
    }

    public void setFl50Scy(Map<Long, Time> Fl50Scy) {
        this.Fl50Scy = Fl50Scy;
    }

    public Map<Long, Time> getFl100Scy() {
        return Fl100Scy;
    }

    public void setFl100Scy(Map<Long, Time> Fl100Scy) {
        this.Fl100Scy = Fl100Scy;
    }

    public Map<Long, Time> getFl200Scy() {
        return Fl200Scy;
    }

    public void setFl200Scy(Map<Long, Time> Fl200Scy) {
        this.Fl200Scy = Fl200Scy;
    }

    public Map<Long, Time> getFr1000Scy() {
        return Fr1000Scy;
    }

    public void setFr1000Scy(Map<Long, Time> Fr1000Scy) {
        this.Fr1000Scy = Fr1000Scy;
    }

    public Map<Long, Time> getFr1650Scy() {
        return Fr1650Scy;
    }

    public void setFr1650Scy(Map<Long, Time> Fr1650Scy) {
        this.Fr1650Scy = Fr1650Scy;
    }

    public Map<Long, Time> getBr50Scy() {
        return Br50Scy;
    }

    public void setBr50Scy(Map<Long, Time> Br50Scy) {
        this.Br50Scy = Br50Scy;
    }

    public Map<Long, Time> getBr100Scy() {
        return Br100Scy;
    }

    public void setBr100Scy(Map<Long, Time> Br100Scy) {
        this.Br100Scy = Br100Scy;
    }

    public Map<Long, Time> getBr200Scy() {
        return Br200Scy;
    }

    public void setBr200Scy(Map<Long, Time> Br200Scy) {
        this.Br200Scy = Br200Scy;
    }

    public Map<Long, Time> getBk50Scy() {
        return Bk50Scy;
    }

    public void setBk50Scy(Map<Long, Time> Bk50Scy) {
        this.Bk50Scy = Bk50Scy;
    }

    public Map<Long, Time> getBk100Scy() {
        return Bk100Scy;
    }

    public void setBk100Scy(Map<Long, Time> Bk100Scy) {
        this.Bk100Scy = Bk100Scy;
    }

    public Map<Long, Time> getBk200Scy() {
        return Bk200Scy;
    }

    public void setBk200Scy(Map<Long, Time> Bk200Scy) {
        this.Bk200Scy = Bk200Scy;
    }

    public Map<Long, Time> getFr50Lcm() {
        return Fr50Lcm;
    }

    public void setFr50Lcm(Map<Long, Time> Fr50Lcm) {
        this.Fr50Lcm = Fr50Lcm;
    }

    public Map<Long, Time> getFr100Lcm() {
        return Fr100Lcm;
    }

    public void setFr100Lcm(Map<Long, Time> Fr100Lcm) {
        this.Fr100Lcm = Fr100Lcm;
    }

    public Map<Long, Time> getFr200Lcm() {
        return Fr200Lcm;
    }

    public void setFr200Lcm(Map<Long, Time> Fr200Lcm) {
        this.Fr200Lcm = Fr200Lcm;
    }

    public Map<Long, Time> getFl50Lcm() {
        return Fl50Lcm;
    }

    public void setFl50Lcm(Map<Long, Time> Fl50Lcm) {
        this.Fl50Lcm = Fl50Lcm;
    }

    public Map<Long, Time> getFl100Lcm() {
        return Fl100Lcm;
    }

    public void setFl100Lcm(Map<Long, Time> Fl100Lcm) {
        this.Fl100Lcm = Fl100Lcm;
    }

    public Map<Long, Time> getFl200Lcm() {
        return Fl200Lcm;
    }

    public void setFl200Lcm(Map<Long, Time> Fl200Lcm) {
        this.Fl200Lcm = Fl200Lcm;
    }

    public Map<Long, Time> getBr50Lcm() {
        return Br50Lcm;
    }

    public void setBr50Lcm(Map<Long, Time> Br50Lcm) {
        this.Br50Lcm = Br50Lcm;
    }

    public Map<Long, Time> getBr100Lcm() {
        return Br100Lcm;
    }

    public void setBr100Lcm(Map<Long, Time> Br100Lcm) {
        this.Br100Lcm = Br100Lcm;
    }

    public Map<Long, Time> getBr200Lcm() {
        return Br200Lcm;
    }

    public void setBr200Lcm(Map<Long, Time> Br200Lcm) {
        this.Br200Lcm = Br200Lcm;
    }

    public Map<Long, Time> getBk50Lcm() {
        return Bk50Lcm;
    }

    public void setBk50Lcm(Map<Long, Time> Bk50Lcm) {
        this.Bk50Lcm = Bk50Lcm;
    }

    public Map<Long, Time> getBk100Lcm() {
        return Bk100Lcm;
    }

    public void setBk100Lcm(Map<Long, Time> Bk100Lcm) {
        this.Bk100Lcm = Bk100Lcm;
    }

    public Map<Long, Time> getBk200Lcm() {
        return Bk200Lcm;
    }

    public void setBk200Lcm(Map<Long, Time> Bk200Lcm) {
        this.Bk200Lcm = Bk200Lcm;
    }

    public Map<Long, Time> getIm100Scy() {
        return Im100Scy;
    }

    public void setIm100Scy(Map<Long, Time> Im100Scy) {
        this.Im100Scy = Im100Scy;
    }

    public Map<Long, Time> getIm200Scy() {
        return Im200Scy;
    }

    public void setIm200Scy(Map<Long, Time> Im200Scy) {
        this.Im200Scy = Im200Scy;
    }

    
    public Map<Long, Time> getIm200Lcm() {
        return Im200Lcm;
    }

    public void setIm200Lcm(Map<Long, Time> Im200Lcm) {
        this.Im200Lcm = Im200Lcm;
    }

    public Map<Long, Time> getIm400Scy() {
        return Im400Scy;
    }

    public void setIm400Scy(Map<Long, Time> Im400Scy) {
        this.Im400Scy = Im400Scy;
    }

    public Map<Long, Time> getIm400Lcm() {
        return Im400Lcm;
    }

    public void setIm400Lcm(Map<Long, Time> Im400Lcm) {
        this.Im400Lcm = Im400Lcm;
    }

    public Map<Long, Time> getFr400Lcm() {
        return Fr400Lcm;
    }

    public void setFr400Lcm(Map<Long, Time> Fr400Lcm) {
        this.Fr400Lcm = Fr400Lcm;
    }

    public Map<Long, Time> getFr1500Lcm() {
        return Fr1500Lcm;
    }

    public void setFr1500Lcm(Map<Long, Time> Fr1500Lcm) {
        this.Fr1500Lcm = Fr1500Lcm;
    }
    
    
    
    
    
}
