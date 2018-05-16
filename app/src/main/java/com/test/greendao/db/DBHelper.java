package com.test.greendao.db;


import java.util.List;


public class DBHelper {

    private static  DBHelper instance = new DBHelper();
    private DaoSession daoSession;

    public DBHelper(){
        MyOpenHelper helper  = new MyOpenHelper(BaseApplication.getContext(),"test_db",null);
        helper.getReadableDatabase();
        daoSession = new DaoMaster(helper.getWritableDatabase()).newSession();
    }

    public static DBHelper getHelper(){
        return instance;
    }

    public DaoSession getDaoSession(){
        return daoSession;
    }

    public String getTableName(Class<?> entityClass){
        return daoSession.getDao(entityClass).getTablename();
    }

    public long countOf(Class<?> entityClass){
        return daoSession.getDao(entityClass).count();
    }

    /**
     * 根据ID获取Entity对象
     *
     * @param entityClass
     * @param id
     * @return
     * @throws Exception
     */
    public <T> T queryById(Class<T> entityClass, Object id){
        List<?> list = daoSession.getDao(entityClass).queryRawCreate("where"+daoSession.getDao(entityClass).getPkProperty().name + " = ?", String.valueOf(id)).list();
        if(!list.isEmpty()){
            return (T) list.get(0);
        }
        return null;
    }

    public <T> List<T> queryForAll(Class<T> entity){
        List<T> list = (List<T>) daoSession.getDao(entity).queryBuilder().list();
        return list;
    }

    /**
     * 根据ID删除Entity对象
     *
     * @param entityClass
     * @return
     * @throws Exception
     */
    public <T> boolean deleteEntity(T entityClass){
        daoSession.delete(entityClass);
        return true;
    }




    /**
     * 保存list Entity对象
     *
     * @param entitys
     * @return
     * @throws Exception
     */
    public <T> boolean saveEntitys(Class<T> entityClass, final List<T> entitys){
        boolean flag = false;
        if(!entitys.isEmpty()){
            try {
                daoSession.runInTx(new Runnable() {
                    @Override
                    public void run() {
                        for(T t : entitys){
                            if(t == null){
                                continue;
                            }
                            daoSession.insertOrReplace(t);
                        }
                    }
                });
                flag =true;
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return flag;
    }

    /**
     * 保存list Entity对象
     *
     * @param entity
     * @return
     * @throws Exception
     */

    public <T> boolean saveEntity(T entity){
        if(entity == null){
            return false;
        }
        daoSession.insertOrReplace(entity);
        return true;
    }

}
