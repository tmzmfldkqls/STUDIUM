<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<script src="<%= root %>/js/sb-admin-2.js"></script>
<script src="<%= root %>/js/metisMenu.min.js"></script>
 <div class="navbar-default sidebar mt-1 ml-3" role="navigation">
                <div class="sidebar-nav navbar-collapse">
            	<h2 class="mt-3 mb-2">������ ������</h2>                   
                            <a href="<%= root %>/admin/admin_main.jsp"><i class="fa fa-dashboard fa-fw" style="font-size:20px;"></i> ��ü ����</a><br>  
                            <a href="<%= root %>/admin?act=mvmemberlist"><i class="fa fa-edit fa-fw" style="font-size:20px;"></i> ȸ������</a><br>
                            <a href="<%= root %>/admin?act=mvspacelist"><i class="fa fa-edit fa-fw" style="font-size:20px;"></i> ���͵��������</a><br>
                            <a href="<%= root %>/admin?act=mvstglist"><i class="fa fa-edit fa-fw" style="font-size:20px;"></i> ���͵�׷����</a><br>
                            <a href="<%= root %>/admin?act=mvmemberchart"><i class="fa fa-bar-chart-o fa-fw" style="font-size:20px;"></i> memberChart</a><br> 
                            <a href="<%= root %>/admin?act=mvloginchart"><i class="fa fa-bar-chart-o fa-fw" style="font-size:20px;"></i> LoginChart</a><br>                 
                </div>
                <!-- /.sidebar-collapse -->
            </div>
 