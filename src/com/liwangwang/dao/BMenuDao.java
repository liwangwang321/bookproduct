package com.liwangwang.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.liwangwang.entity.TreeNode;
import com.liwangwang.util.JsonBaseDao;
import com.liwangwang.util.JsonUtils;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.StringUtils;

public class BMenuDao extends JsonBaseDao {
	private String role_id;
	private BMenuRoleDao bmrd = new BMenuRoleDao();
	
	public List<Map<String,Object>> list(Map<String, String[]> pamap ,PageBean pageBean,String role_id) throws InstantiationException, IllegalAccessException, SQLException{
		String sql = "select * from b_role where role_id = '"+role_id+"' ";
		
		return super.executeQuery(sql, pageBean);
	}
	
	//流程：第一步
		public List<TreeNode> list(Map<String, String[]> map,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
			role_id = JsonUtils.getParamVal(map, "role_id");
			
			List<Map<String, Object>> listMenu = this.listMenu(map, pageBean);//调用查询数据库的方法来获取数据
			List<TreeNode> treeNodesList = new ArrayList<>();//先搞一个容器准备装着
			menuList2TreeNodeList(listMenu, treeNodesList);//调用来将查询过来的menu数据转换为treeNode数据
			
			return treeNodesList;
		}
		
		
		
		
		
		//流程之外
			public List<Map<String, Object>> listMenuSef(Map<String, String[]> map,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
				String sql = "select * from t_easyui_menu where true ";
				String id = JsonUtils.getParamVal(map, "menuHid");//这个是从jsp界面传过来的
				if(StringUtils.isNotBlank(id)) {
					sql = sql + " and menu_id in ("+id+") ";
				}else {
					sql = sql + " and menu_id = -1";
				}
				
				return super.executeQuery(sql, pageBean);
			}
		
		
		
		
		
		
		
		/**
		 * 查询menu表的数据
		 * @param map
		 * @param pageBean
		 * @return
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws SQLException
		 */
		//流程：第二步
		public List<Map<String, Object>> listMenu(Map<String, String[]> map,PageBean pageBean) throws InstantiationException, IllegalAccessException, SQLException{
			String sql = "select * from b_menu where true ";
			String id = JsonUtils.getParamVal(map, "id");//第一次为空
			if(StringUtils.isNotBlank(id)) {
				sql = sql + " and menu_pid = "+id;
			}else {
				sql = sql + " and menu_pid = -1";//在第一次的时候执行
			}
			
			return super.executeQuery(sql, pageBean);
		}

		/**转换的单个转换
		 * 
		 * menu表的数据不符合easyui树形展示的数据格式
		 * 需要转化成easyui所能识别的数据格式
		 * 
		 * @param map
		 * @param treeNode
		 * @throws InstantiationException
		 * @throws IllegalAccessException
		 * @throws SQLException
		 */
		//流程：第四步
		private void menu2TreeNode(Map<String, Object> map,TreeNode treeNode) throws InstantiationException, IllegalAccessException, SQLException{
				treeNode.setId(map.get("menu_id").toString() ); //单个的赋值
				treeNode.setText(map.get("menu_name").toString());
				List<Map<String, Object>> statelist = bmrd.statelist(role_id, map.get("menu_id")+"");
				if(statelist!=null&&statelist.size()>0) {
					Map<String, Object> map2 = statelist.get(0);
					int state = (int)map2.get("rolemenu_state");
					if(state==0) {
						treeNode.setChecked(true);
					}
					else {
						treeNode.setChecked(false);
					}
					
				}
				
				if(map.get("menu_icon")!=null) {
					treeNode.setIconCls(map.get("menu_icon").toString());
				}
				treeNode.setAttributes(map);
				
				//treeNode.setChildren(children);
				Map<String, String[]> jspMap = new HashMap<>();//给参数集合实例化
				jspMap.put("id", new String[] {treeNode.getId()});//给参数中加入一个id的参数
				List<Map<String, Object>> listMenu = this.listMenu(jspMap, null); // 重点!!! 如果第二次查询没有这个id的话就结束,否则 二，三，四流程继续
				List<TreeNode> treeNodeList = new ArrayList<>();  //用一个List<TreeNode>集合准备装着子节点的所有东西
				menuList2TreeNodeList(listMenu, treeNodeList); //如果有的话就继续运行，否则不运行
				treeNode.setChildren(treeNodeList); //将treeNode的children属性赋值
		}
		
		//流程：第三步
		private void menuList2TreeNodeList(List<Map<String, Object>> mapList,List<TreeNode> treeNodeList) throws InstantiationException, IllegalAccessException, SQLException{
				TreeNode treeNode = null;		//准备最后放入集合内部TreeNode
				for (Map<String, Object> map : mapList) {//遍历List<Menu>中然后两者相互转换。因为最后的结果就是List<TreeNode>
					treeNode = new TreeNode();
					menu2TreeNode(map, treeNode);//调用到第一流程中的最后一步：为TreeNode设值
						
						treeNodeList.add(treeNode);//将转换完成的加入到treeNode
				}
		}
		//通过一个子节点，从而获取到他的父节点
		public List<Map<String, Object>> listpid(String menu_id) throws InstantiationException, IllegalAccessException, SQLException{
			String sql = "select * from b_menu where menu_id = '"+menu_id+"' ";
			
			
			return super.executeQuery(sql, null);
		}
		//通过一个父节点，从而获取到他旗下的所有子节点
		public List<Map<String, Object>> listmenu_id(String menu_pid) throws InstantiationException, IllegalAccessException, SQLException{
			String sql = "select * from b_menu where menu_pid = '"+menu_pid+"' ";
			
			
			return super.executeQuery(sql, null);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
}
