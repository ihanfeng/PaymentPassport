package com.cssweb.distributedsession;

import com.couchbase.client.CouchbaseClient;
import com.esotericsoftware.kryo.Kryo;
import com.esotericsoftware.kryo.io.Input;
import com.esotericsoftware.kryo.io.Output;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.math.BigDecimal;
import java.net.URI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * Created by chenhf on 14-3-4.
 */
public class SessionCouchBaseImpl extends AbstractCsswebSession implements CsswebSession {

    private String bucketName;
    private String password;
    private CouchbaseClient client;

    public static class AccCol
    {
        private List<Account> accountList;

        public AccCol(List<Account> accountList)
        {
            this.accountList = accountList;
        }

        public List<Account> get()
        {
            return accountList;
        }
    };
    public static void main(String[] args) throws Exception {


        /*
        // (Subset) of nodes in the cluster to establish a connection
        List<URI> hosts = Arrays.asList(
                new URI("http://192.168.1.201:8091/pools"),
                new URI("http://192.168.1.202:8091/pools"),
                new URI("http://192.168.1.203:8091/pools")
        );

        // Name of the Bucket to connect to
        String bucket = "default";

        // Password of the bucket (empty) string if none
        String password = "";

        // Connect to the Cluster
        CouchbaseClient client = new CouchbaseClient(hosts, bucket, password);

        // Store a Document
        int expireTime = 0;

        Account acc1 = new Account();
        acc1.setAccountId(1);
        acc1.setAccountName("余额宝");
        acc1.setAvailable(new BigDecimal("100.01"));

        Account acc2 = new Account();
        acc2.setAccountId(2);
        acc2.setAccountName("小金库");
        acc2.setAvailable(new BigDecimal("1000.01"));

        List<Account> accountList = new ArrayList<Account>();
        accountList.add(acc1);
        accountList.add(acc2);


        Date now = new Date();
        long begin = System.currentTimeMillis();
        System.out.println("开始");

        Gson gson = new Gson();
        String tmp = gson.toJson(accountList);

        client.set("userid:account", expireTime, tmp).get();


        // Retreive the Document and print it
        String json = (String) client.get("userid:account");



        List<Account> accs =  gson.fromJson(json, new TypeToken<List<Account>>(){}.getType() );
        //HashMap<String,String> m=gson.fromJson(t, new TypeToken<HashMap<String,String>>(){}.getType());
        //Person person=gson.fromJson(txt, Person.class);
        for (Account acc : accs) {

            System.out.println("account name = " + acc.getAccountName());
            System.out.println("account id = " + acc.getAccountId());
            System.out.println("account available = " + acc.getAvailable());
        }

        long end = System.currentTimeMillis();
        System.out.println("运行时间：" + (end - begin) );

        // Shutting down properly
        client.shutdown();
        */
    }

    @Override
    public boolean set(String key, Object obj) {
        return false;
    }

    @Override
    public boolean set(String key, String obj) {
        return false;
    }

    @Override
    public boolean setExpire(String key, int expire) {
        return false;
    }

    @Override
    public Object get(String key) {
        return null;
    }

    @Override
    public List<String> getKeys(String key) {
        return null;
    }

    @Override
    public boolean remove(String key) {
        return false;
    }

    @Override
    public boolean removeAll(String key) {
        return false;
    }


}
