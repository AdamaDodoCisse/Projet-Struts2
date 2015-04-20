package fr.appli.qcm.actions.test;

import java.util.ArrayList;

/**
 * Created by dodo on 06/01/2015.
 */
public class TestAction {
    private ArrayList<String> list;

    public String index()
    {
        if(list != null)
            System.out.println(list);

        return "success";
    }



    public void setList(ArrayList<String> list) {
        this.list = list;
    }

    public ArrayList<String> getList() {
        return list;
    }
}
