ExtJS and Play! Framework
Ext.define('Account', {
    extend : 'Ext.data.Model',
    fields : [{
        name : 'description', type: 'string'
    }, {
        name : 'accountNumber', type: 'string'
    }]
}); 

store = Ext.create('Ext.data.Store', {
    model: 'Account',
    proxy: {
           type: 'ajax',
           autoSave: false,
           api: {
               read: 'account/research',
               create: 'account/new',
               update: 'account/update',
               destroy: 'account/delete'
           },
           reader: {
               type: 'json'
           },
           writer: {
               type: 'json',
               writeAllFields: true,  
               encode: false
           }
     }
});
	
var compte = Ext.create('Account', {
    description: 'test'
});
store.create(0, compte);
	
public static void new(Account account) {
    account.save();
    renderJSON("{success: true}");
}
	
Account account = new Accouunt(params)
	
Account account = new Account()
account.properties = params