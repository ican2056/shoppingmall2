//服务层
//网页加载完成就启动
angular.element(window).bind('load', function() {

});

app.service('goodsService',function($http){
	    	
	//读取列表数据绑定到表单中
	this.findAll=function(){
		return $http.get('/goods/findAll.do');
	}
	//分页 
	this.findPage=function(page,rows){
		return $http.get('/seller/goods/findPage?page='+page+'&rows='+rows);
	}
	//查询实体
	this.findOne=function(id){
		return $http.get('/seller/goods/findOne?id='+id);
	}
	//增加 
	this.add=function(entity){
		return  $http.post('../goods/add.do',entity );
	}
	//修改 
	this.update=function(entity){
		return  $http.post('../goods/update.do',entity );
	}
	//删除
	this.dele=function(ids){
		return $http.get('../goods/delete.do?ids='+ids);
	}
	//搜索
	this.search=function(page,rows,searchEntity){
		return $http.post('/seller/goods/findPage?page='+page+"&rows="+rows, searchEntity);
	}    	
});
