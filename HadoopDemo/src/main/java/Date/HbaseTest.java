//package Date;
//
//public class HbaseTest {
////    a)nglish:45 	Math:89	Computer:100
//
//    public void testPut() throws Exception {
//        conf= HBaseConfiguration.create();
//        // 对于hbase的客户端来说，只需要知道hbase所使用的zookeeper集群地址就可以了
//        // 因为hbase的客户端找hbase读写数据完全不用经过hmaster
//        conf.set("hbase.zookeeper.quorum","vm0:2181,vm1:2181,vm2:2181");
//        //获取链接
//        conn=ConnectionFactory.createConnection(conf);
//
//        //构建一个 table对象，通过table对象来添加数据
//        Table table = conn.getTable(TableName.valueOf("t_user_info"));
//        //创建一个集合，用于存放Put对象
//        ArrayList<Put> puts = new ArrayList<Put>();
//
//        // 构建一个put对象（kv），指定其行键  例如hbase shell:  put '表名','rowkey','列族:列名称','值'
//        Put put01 = new Put(Bytes.toBytes("scofield"));
//        put01.addColumn(Bytes.toBytes("score"), Bytes.toBytes("English"), Bytes.toBytes("45"));
//        put01.addColumn(Bytes.toBytes("score"), Bytes.toBytes("Math"), Bytes.toBytes("89"));
//        put01.addColumn(Bytes.toBytes("score"), Bytes.toBytes("Computer"), Bytes.toBytes("100"));
//
//
//        //把所有的put对象添加到一个集合中
//        puts.add(put01);
//
//        //一起提交所有的记录
//        table.put(puts);
//
//        table.close();
//        conn.close();
//
//    }
//
//
//}

