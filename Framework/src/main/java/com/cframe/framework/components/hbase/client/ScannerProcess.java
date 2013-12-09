package com.cframe.framework.components.hbase.client;

import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.client.HConnection;
import org.apache.hadoop.hbase.client.HConnectionManager;
import org.apache.hadoop.hbase.client.HTableInterface;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.filter.Filter;
import org.apache.hadoop.hbase.filter.RegexStringComparator;
import org.apache.hadoop.hbase.filter.ValueFilter;
import org.apache.hadoop.hbase.filter.CompareFilter.CompareOp;
import org.apache.hadoop.hbase.util.Bytes;

public class ScannerProcess {
	public static int getCountEqualToColumn(Configuration conf, String tableNm, String cf, String columeNm, String equal1) throws IOException{
		int count = 0;
		HConnection connection = HConnectionManager.createConnection(conf);
		HTableInterface twitsTable = connection.getTable(tableNm);
	        
        Scan s = new Scan();
        s.addColumn(Bytes.toBytes(cf), Bytes.toBytes(columeNm));
        Filter f = new ValueFilter(
        		CompareOp.EQUAL,
        		new RegexStringComparator(equal1)
        		);
        s.setFilter(f);
        
        ResultScanner rs = twitsTable.getScanner(s);
        
        for(Result r : rs){
        	count++;
        }
        twitsTable.close();
        connection.close();
        return count;
        
	}
}
