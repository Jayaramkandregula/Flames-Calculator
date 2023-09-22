package com.jayaram12.flamescalculator;

import java.util.ArrayList;
import java.util.Arrays;

public class flames_calculator {
    public String get_String(String p1_name,String p2_name){
        p1_name=p1_name.toUpperCase();
        p2_name=p2_name.toUpperCase();
        char[] p1_name_array=p1_name.toCharArray();
        char[] p2_name_array=p2_name.toCharArray();
        for(int i=0;i<p1_name_array.length;i++)
        {
            for(int j=0;j<p2_name_array.length;j++)
            {
                if(p1_name_array[i]==p2_name_array[j])
                {
                    p1_name_array[i] = ' ';
                    p2_name_array[j] = ' ';
                    break;
                }
            }
        }
        ArrayList<String> flames=new ArrayList<String>(Arrays.asList("Friends","Love","Affection","Marriage","Enemy","Siblings"));
        int uniqueletters=0;
        for(int i=0;i<p1_name_array.length;i++)
        {
            if(p1_name_array[i]!=' ')
                uniqueletters++;
        }
        for (int j=0;j<p2_name_array.length;j++)
        {
            if(p2_name_array[j]!=' ')
                uniqueletters++;
        }
        if(uniqueletters==0) return flames.get(5);
        int curr_index=0;
        while(flames.size()>1)
        {
            for(int i=0;i<uniqueletters;i++)
            {
                curr_index++;
                if(curr_index>flames.size())
                {
                    curr_index=1;
                }
            }
            flames.remove(curr_index-1);
            curr_index--;
        }
        return flames.get(0);
    }
}
