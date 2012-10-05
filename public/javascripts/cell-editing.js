Ext.onReady(function() {
					 
	// make sample array data
	var sampleData = [
		[1,'Monkey D Luffy','Captain','I will become the pirate king'],
		[2,'Roronoa Zoro','Swordman','Become the greatest swordman'],
		[3,'Sanji','Cook','Find all blue'],
		[4,'Usopp','Sniper','Become the greatest warrior'],
		[5,'Nami','Navigator','Draw map of the world']
	];
	
	// create the data store
	
	var store = Ext.create('Ext.data.ArrayStore', {
		fields: [
			{name: 'id', type: 'int'},
			{name: 'name'},
			{name: 'position'},
			{name: 'ambition'}
		],
		data: sampleData
	});
	
	// create the grid
	var grid = Ext.create('Ext.grid.Panel', {
		store: store,
		columns: [
			{id:'id',header: 'ID', width: 30, sortable: true, dataIndex: 'id'},
			{header: 'Name', width: 100, dataIndex: 'name'},
			{header: 'Position', width: 100, dataIndex: 'position'},
			{header: 'Ambition', width: 250, dataIndex: 'ambition'}
		],
		stripeRows: true,
		height:180,
		width:500,
		renderTo: 'grid-example',
		title:'Straw Hats Crew'
	});

});
