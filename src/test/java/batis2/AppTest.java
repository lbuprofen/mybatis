package batis2;

import batis2.dao.Iselect;
import batis2.entity.Role;
import batis2.util.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.Date;
import java.util.List;


/**
 * Unit test for simple App.
 */
public class AppTest {
    private Logger logger = Logger.getLogger(AppTest.class);

    /**
     * Rigorous Test :-)
     */
    @Test
    public void Cand() {
        SqlSession sqlSession = null;
        List<Role> user = null;
        Role userlist = new Role();
        try {
            //哈哈哈哈哈爱你哟
            //克尔克
            sqlSession = MyBatisUtil.createSqlSession(sqlSession);
            Iselect and = sqlSession.getMapper(Iselect.class);
            List<Role> list = and.getUserListByUserName("大");
            for (Role item : list
                    ) {
                System.out.println(item.getProductName());
            }
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
      public void Can() {
          SqlSession sqlSessionc=null;
          int count=0;
          try {
              SqlSession sqlSession = MyBatisUtil.createSqlSession(sqlSessionc);
              Role user=new Role();
              user.setId(18);
              user.setProCode("BK_MFS003");
              user.setProName("浙江温州有限公司");
              user.setProDesc("长期合作伙伴，主营产品：美式奶茶，奶茶面膜、中式奶茶、奶茶洗面奶、奶茶美肤品等");
              user.setProContact("赵海");
              user.setProPhone("17611135322");
              user.setProAddress("河北邯郸丛台区");
              user.setProFax("0412-36638876");
              user.setCreatedBy(1);
              user.setPayment("未付款");
              user.setCreationDate(new Date());
              count = sqlSession.getMapper(Iselect.class).add(user);
              sqlSession.commit();
          }catch (Exception e){
            e.printStackTrace();
            sqlSessionc.rollback();
            count=0;
          }finally {
              MyBatisUtil.createSqlSession(sqlSessionc);
          }
          logger.debug("ccccc:"+count);
      }
    @Test
    public void Select() {
        SqlSession sqlSession = null;
        List<Role> user = null;
        Role uselist = new Role();
        try {
            sqlSession = MyBatisUtil.createSqlSession(sqlSession);
            Iselect and = sqlSession.getMapper(Iselect.class);
            List<Role> list = and.provider("大");
            for (Role item : list
                    ) {
                System.out.println(item.getProductName());
            }
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
    @Test
    public void Selects(){
     SqlSession sqlSession=null;
     List<Role> user=null;
     Role uselist = new Role();
        try {
            sqlSession = MyBatisUtil.createSqlSession(sqlSession);
            Iselect and = sqlSession.getMapper(Iselect.class);
            List<Role> list =and.providee(12);
            for (Role item : list) {
                System.out.println(item.getId()+","+item.getProCode()+","+item.getProductName()+","+
                        item.getProName()+","+item.getProContact()+","+item.getProPhone()+","+item.getBill().
                        getCreationDate()+","+item.getBill().getTotalPrice()+","+item.getPayment());
            }
            System.out.println(list.size());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyBatisUtil.closeSqlSession(sqlSession);
        }
    }
}