package com.liwangwang.web;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.liwangwang.dao.BookDao;
import com.liwangwang.util.PageBean;
import com.liwangwang.util.ResponseUtil;
import com.zking.framework.ActionSupport;

public class BookAction extends ActionSupport{
	
	private BookDao bd = new BookDao();
	
	public String indexlist(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			List<Map<String, Object>> list = bd.indexlist(req.getParameterMap(), null);
			ObjectMapper om = new ObjectMapper();
			ResponseUtil.write(resp, om.writeValueAsString(list));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "no";
	}
	
	public String findBook(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			PageBean pageBean = new PageBean();
			pageBean.setRequest(req);
			pageBean.setRows(5);
			List<Map<String, Object>> findBook = bd.findBook(req.getParameterMap(), pageBean);
			req.setAttribute("listset", "listset");
			req.setAttribute("bookList", findBook);
			req.setAttribute("pageBean", pageBean);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "findBook";
	}
	
	public String shop(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
			HttpSession session = req.getSession();
			List<Map<String, Object>> findBook = bd.findBook(req.getParameterMap(), null);
			if(findBook!=null&&findBook.size()>0) {
				if(findBook.size()==1) {
					
					Map<String, Object> book = findBook.get(0);//找到了一个book
					book.put("count", 1);//给准备加入到集合的book加个数量的属性;
					int book_id =  Integer.parseInt(book.get("book_id")+"");
					
					List<Map<String, Object>> shops = (List<Map<String, Object>>) session.getAttribute("shoplist");//存储着的集合
					
					int book_ids;
					boolean f = false;
					if(shops!=null) {
						for (Map<String, Object> map : shops) {
							book_ids = Integer.parseInt(map.get("book_id")+"");
							if(book_id==book_ids) {
								map.put("count", (int)map.get("count")+1);
								f = true;
							}
							
						}
					}
					else {
						 shops = new ArrayList<>();
					}
					
					
					if(f==false) {
						
						shops.add(book);
					}
					session.setAttribute("shoplist", shops);
					ObjectMapper  om = new ObjectMapper();
					ResponseUtil.write(resp, om.writeValueAsString(shops));
					
				}
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return "no";
	}
	
	public String shoplist(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
				HttpSession session = req.getSession();
				List<Map<String, Object>> shops = (List<Map<String, Object>>) session.getAttribute("shoplist");//存储着的集合
				ObjectMapper  om = new ObjectMapper();
				ResponseUtil.write(resp, om.writeValueAsString(shops));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "no";
	}
	public String shopdel(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
				HttpSession session = req.getSession();
				List<Map<String, Object>> shops = (List<Map<String, Object>>) session.getAttribute("shoplist");//存储着的集合
				String book_id = req.getParameter("book_id");
				for (Map<String, Object> map : shops) {
					if(Integer.parseInt(book_id)==(long)map.get("book_id")) {
						shops.remove(map);
					}
				}
				
				ObjectMapper  om = new ObjectMapper();
				ResponseUtil.write(resp, om.writeValueAsString(shops));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "no";
	}
	
	public String shopedit(HttpServletRequest req,HttpServletResponse resp) {
		
		try {
				HttpSession session = req.getSession();
				List<Map<String, Object>> shops = (List<Map<String, Object>>) session.getAttribute("shoplist");//存储着的集合
				String book_id = req.getParameter("book_id");
				String val = req.getParameter("value");
				for (Map<String, Object> map : shops) {
					if(Integer.parseInt(book_id)==(long)map.get("book_id")) {
						map.put("count", Integer.parseInt(val));
					}
				}
				ObjectMapper  om = new ObjectMapper();
				ResponseUtil.write(resp, om.writeValueAsString(shops));
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "no";
	}
	
public String shopexit(HttpServletRequest req,HttpServletResponse resp) {
		
		HttpSession session = req.getSession();
		session.setAttribute("shoplist", null);
		
		return "shopping";
	}
	
public String singebook(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		HttpSession session = req.getSession();
		List<Map<String, Object>> findBook = bd.findBook(req.getParameterMap(), null);
		for (Map<String, Object> map : findBook) {
			map.put("count", 1);
		}
		session.setAttribute("myshoplist", findBook);//保存到另一个集合，与购物车的集合分开
		req.setAttribute("shoptype", 1);//直接购买
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "addorder";
}

public String addbook(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		
		int addBook = bd.addBook(req.getParameterMap());
		if(addBook>0) {
			System.out.println("增加");
		}else {
			System.out.println("失败");
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook1";
}

public String listBook(HttpServletRequest req,HttpServletResponse resp) {
	try {
		PageBean pageBean = new PageBean();
		pageBean.setRows(5);
		pageBean.setRequest(req);
		
		List<Map<String, Object>> listBook = bd.listBook(req.getParameterMap(), pageBean);
		
		req.setAttribute("listBookset", "listBookset");
		req.setAttribute("listBook", listBook);
		req.setAttribute("pageBean", pageBean);
		String book_state = req.getParameter("book_state");
		if("1".equals(book_state)) {
			return "listBook1";
		}
		else if("2".equals(book_state)) {
			return "listBook2";
		}
		
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook3";
}
//跳转到上传界面
public String uploadBookImage(HttpServletRequest req,HttpServletResponse resp) {
	String book_id = req.getParameter("book_id");
	req.setAttribute("book_id", book_id);
	
	return "uploadBookImage";
}
//跳转到修改界面
public String preedit(HttpServletRequest req,HttpServletResponse resp) {
	try {
		List<Map<String, Object>> findBook = bd.listallbook(req.getParameterMap(), null);
		Map<String, Object> map = findBook.get(0);
		req.setAttribute("book", map);
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return "editBook";
}

//修改书本信息
public String editbook(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editbook = bd.editbook(req.getParameterMap());
		if(editbook>0) {
			System.out.println("成功");
		}
		else {
			System.out.println("失败");
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook1";
}
//删除书本信息
public String delbook(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editbook = bd.delbook(req.getParameterMap());
		if(editbook>0) {
			System.out.println("成功");
			
			if(req.getParameter("type").equals("1")) {
				return "listBook1";
			}
			else if(req.getParameter("type").equals("2")){
				return "listBook3";
			}
			
		}
		else {
			System.out.println("失败");
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook1";
} 
//下架，修改书本状态修改为3
public String editstate3(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editbook = bd.editstate(req.getParameterMap());
		if(editbook>0) {
			System.out.println("成功");
		}
		else {
			System.out.println("失败");
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook2";
}
//上架，修改书本状态修改为2
public String editstate2(HttpServletRequest req,HttpServletResponse resp) {
	
	try {
		int editbook = bd.editstate2(req.getParameterMap());
		if(editbook>0) {
			System.out.println("成功");
		}
		else {
			System.out.println("失败");
		}
		
	}catch (Exception e) {
		e.printStackTrace();
	}
	
	return "listBook3";
}


public String upload(HttpServletRequest req,HttpServletResponse resp) {
	//接受表单的值
	 String uploadPath = "jsp/imgs/"; // 上传文件的目录    
     String tempPath = "uploadpic/uploadtmp/"; // 临时文件目录    
     String serverPath = null;   
     String[] fileType = new String[]{".jpg",".gif",".bmp",".png",".jpeg",".ico"};  
     int sizeMax = 5;//图片最大上限    
    
	
		
     	
        // 服务器端根目录  
        serverPath = req.getServletContext().getRealPath("/").replace("\\", "/");    
//        System.out.println(serverPath);  
        //Servlet初始化时执行,如果上传文件目录不存在则自动创建    
        if(!new File(serverPath+uploadPath).isDirectory()){   
            new File(serverPath+uploadPath).mkdirs();    
        }    
        if(!new File(serverPath+tempPath).isDirectory()){  
            new File(serverPath+tempPath).mkdirs();  
        }   
        DiskFileItemFactory factory = new DiskFileItemFactory();  
        factory.setSizeThreshold(5*1024); //最大缓存    
        factory.setRepository(new File(serverPath+tempPath));//临时文件目录    
            
        ServletFileUpload upload = new ServletFileUpload(factory);  
        upload.setSizeMax(sizeMax*1024*1024);//文件最大上限   
            
        String filePath = null;  
        String fileName="";
      
        try {    
            List<FileItem> items = upload.parseRequest(req);//获取所有文件列表   
            //  
            for (int i=0;i<items.size();i++) {  
                //里面一个for循环，获取一行的数据  
            		FileItem item = items.get(i);  
            		if(!item.isFormField()){//文件名    
            			fileName = item.getName().toLowerCase();  
            			if(fileName.endsWith(fileType[0])||fileName.endsWith(fileType[1])||fileName.endsWith(fileType[2])||fileName.endsWith(fileType[3])||fileName.endsWith(fileType[4])||fileName.endsWith(fileType[5])){    
//                        String uuid = UUID.randomUUID().toString();    
            				filePath = serverPath+uploadPath+fileName;  
       //                System.out.println(filePath);  
            				File file = new File(filePath);  
            				item.write(file);  
            				System.out.println(i+"    "+fileName);  
            				
            				
            			}else {  
            				req.setAttribute("errorMsg", "上传失败,请确认上传的文件存在并且类型是图片!");  
            				req.getRequestDispatcher("uploaderror.jsp").forward(req,resp);   
            			}  
            		}else {  
            			//非文件流     
            			String value=item.getString();  
            			value = new String(value.getBytes("ISO-8859-1"),"UTF-8");  
            			
	    				
            		}  
            }   
        } catch (Exception e) {  
            e.printStackTrace();    
            req.setAttribute("errorMsg", "上传失败,请确认上传的文件存在并且类型是图片!");  
            try {
				req.getRequestDispatcher("uploaderror.jsp").forward(req,resp);
			} catch (ServletException | IOException e1) {
				e1.printStackTrace();
			}   
        }  
		//String upath="images\\"+fileName;
		//String uuid=req.getParameter("uid");
		//int uid=Integer.parseInt(uuid);
		
		
		
		
		System.out.print("fileName:"+fileName+"   ");
		
		try {
			int n = bd.editimage(req.getParameterMap(), fileName,req.getParameter("book_id"));
			if(n>0) {
				System.out.println("成功");
			}
			else {
				System.out.println("失败");
			}
			
		}  catch (Exception e) {
			e.printStackTrace();
		}
		
	return "listBook2";
}



	
}
