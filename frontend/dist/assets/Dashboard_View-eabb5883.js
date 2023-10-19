import{u as f,_,e as n,o as a,c,a as e,F as w,f as b,t as i,w as U,g as $,p as v,h as x,i as C,j as D,k as S,d as g,l as E,m as A,n as T,q as k,s as L,x as F}from"./index-1b3ec332.js";import{U as N}from"./User_Footer_Menu-fd6895aa.js";import{P}from"./PageTitleWithButton-b9a5ace2.js";const B=f(),l={headers:{Authorization:`Bearer ${B.token}`}},R={name:"UserTableDashboard",data(){return{config:l,token:B.token,users:[]}},created(){this.fetchUsers()},methods:{async fetchUsers(){try{const t=await n.get("/api/user/all",l);this.users=t.data}catch(t){console.log("Error fetching Users: ",t)}},async sortById(){const t="userId";try{const s=await n.post("/api/user/customSort",{sorting:t},l);this.users=s.data}catch(s){console.log(`Error fetching Users with desired sorting method: ${t}`,s)}},async sortByUsername(){const t="username";try{const s=await n.post("/api/user/customSort",{sorting:t},l);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByFirst(){const t="firstname";try{const s=await n.post("/api/user/customSort",{sorting:t},l);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByLast(){const t="lastname";try{const s=await n.post("/api/user/customSort",{sorting:t},l);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByRole(){try{const t=await n.post("/api/user/customSort",{sorting:"role"},l);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByLogin(){try{const t=await n.post("/api/user/customSort",{sorting:"login"},l);this.users=t.data,this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByIncidents(){try{const t=await n.post("/api/user/customSort",{sorting:"incidents"},l);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByPasswordChanges(){try{const t=await n.post("/api/user/customSort",{sorting:"pwchanges"},l);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},testMethod(){alert("Geht")},deleteUser(t){confirm("Do you really want to delete User with id: "+t)&&alert("Deleted")}}},V={class:"container-sm mt-3"},G={class:"table table-striped"},M=e("th",{scope:"col"},"Actions",-1),z=e("td",null,"Dummy",-1),q=e("td",null,"Dummy",-1),W={class:"dropdown"},j=e("button",{class:"btn dropdown-toggle",type:"button","data-bs-toggle":"dropdown","aria-expanded":"false"},null,-1),H={class:"dropdown-menu"},J=["onClick"],K=e("li",null,[e("a",{class:"dropdown-item clickable",id:"changepw",href:"#"},"Change Password")],-1);function O(t,s,p,m,d,r){return a(),c("div",V,[e("table",G,[e("thead",null,[e("tr",null,[e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[0]||(s[0]=(...o)=>r.sortById&&r.sortById(...o))},"Id"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[1]||(s[1]=(...o)=>r.sortByUsername&&r.sortByUsername(...o))},"Username"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[2]||(s[2]=(...o)=>r.sortByFirst&&r.sortByFirst(...o))},"Firstname"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[3]||(s[3]=(...o)=>r.sortByLast&&r.sortByLast(...o))},"Last"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[4]||(s[4]=(...o)=>r.sortByRole&&r.sortByRole(...o))},"Role"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[5]||(s[5]=(...o)=>r.sortByLogin&&r.sortByLogin(...o))},"Last Login"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[6]||(s[6]=(...o)=>r.sortByIncidents&&r.sortByIncidents(...o))},"Assigned Incidents"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[7]||(s[7]=(...o)=>r.sortByPasswordChanges&&r.sortByPasswordChanges(...o))},"Last Password Change"),M])]),e("tbody",null,[(a(!0),c(w,null,b(d.users,o=>(a(),c("tr",{key:o.id},[e("td",null,i(o.userId),1),e("td",null,i(o.username),1),e("td",null,i(o.firstname),1),e("td",null,i(o.lastname),1),e("td",null,i(o.highestAuthority),1),z,e("td",null,i(o.assignedIncidents),1),q,e("td",null,[e("div",W,[j,e("ul",H,[e("li",null,[e("a",{class:"dropdown-item clickable",id:"edit",onClick:s[8]||(s[8]=U((...y)=>t.editUser&&t.editUser(...y),["stop"]))},"Edit")]),e("li",null,[e("a",{class:"dropdown-item clickable",id:"delete",onClick:U(y=>r.deleteUser(o.id),["stop"])},"Delete",8,J)]),K])])])]))),128))])])])}const Q=_(R,[["render",O]]),X={name:"NotFound"};function Y(t,s,p,m,d,r){return a(),c("h4",null,"Not found")}const Z=_(X,[["render",Y]]);const tt=f(),st={name:"IncidentTable",data(){return{token:tt.token,incidents:[]}},created(){this.fetchIncidents()},methods:{async fetchIncidents(){const t={headers:{Authorization:`Bearer ${this.token}`}};try{const s=await n.get("api/incident/all",t);this.incidents=s.data}catch(s){console.error("Error occurred fetching incidents:",s)}},goToDetails(t){$.push({name:"incident-details",params:{id:t}})}}},et=t=>(v("data-v-f20a2df3"),t=t(),x(),t),ot={class:"table table-hover"},rt=et(()=>e("thead",null,[e("tr",null,[e("th",null," Incident Id"),e("th",null," Incident Titel")])],-1)),nt=["onClick"];function at(t,s,p,m,d,r){return a(),c("table",ot,[rt,e("tbody",null,[(a(!0),c(w,null,b(d.incidents,o=>(a(),c("tr",{key:o.id,onClick:y=>r.goToDetails(o.incidentId)},[e("td",null,i(o.incidentId),1),e("td",null,i(o.titel),1)],8,nt))),128))])])}const ct=_(st,[["render",at],["__scopeId","data-v-f20a2df3"]]);const I=f(),h={headers:{Authorization:`Bearer ${I.token}`}},u="/api/user",it={name:"ActiveUsers",data(){return{config:h,token:I.token,users:[]}},created(){this.fetchUsers()},methods:{async fetchUsers(){try{const t=await n.get(u+"/all",h);this.users=t.data}catch(t){console.log("Error fetching Users: ",t)}},async sortById(){const t="userId";try{const s=await n.post(u+"/customSort",{sorting:t},h);this.users=s.data}catch(s){console.log(`Error fetching Users with desired sorting method: ${t}`,s)}},async sortByUsername(){const t="username";try{const s=await n.post(u+"/customSort",{sorting:t},h);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByFirst(){const t="firstname";try{const s=await n.post(u+"/customSort",{sorting:t},h);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByLast(){const t="lastname";try{const s=await n.post(u+"/customSort",{sorting:t},h);this.users=s.data}catch(s){console.log("Error fetching Users with desired sorting method: id",s)}},async sortByRole(){try{const t=await n.post(u+"/customSort",{sorting:"role"},h);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByLogin(){try{const t=await n.post(u+"/customSort",{sorting:"login"},h);this.users=t.data,this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByIncidents(){try{const t=await n.post(u+"/customSort",{sorting:"incidents"},h);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},async sortByPasswordChanges(){try{const t=await n.post(u+"/customSort",{sorting:"pwchanges"},h);this.users=t.data}catch(t){console.log("Error fetching Users with desired sorting method: id",t)}},testMethod(){alert("Geht")},deleteUser(t){confirm("Do you really want to delete User with id: "+t)&&alert("Deleted")}}},dt={class:"container-sm mt-3"},lt={class:"table table-striped"};function ht(t,s,p,m,d,r){return a(),c("div",dt,[e("table",lt,[e("thead",null,[e("tr",null,[e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[0]||(s[0]=(...o)=>r.sortById&&r.sortById(...o))},"Id"),e("th",{scope:"col",class:"clickable text-nowrap",onClick:s[1]||(s[1]=(...o)=>r.sortByUsername&&r.sortByUsername(...o))},"Username")])]),e("tbody",null,[(a(!0),c(w,null,b(d.users,o=>(a(),c("tr",{key:o.id},[e("td",null,i(o.userId),1),e("td",null,i(o.username),1)]))),128))])])])}const ut=_(it,[["render",ht]]),pt={name:"DashboardCard",props:{cardTitle:String,component:String},components:{UserTableDashboard:Q,IncidentTable:ct,NotFound:Z,ActiveUsers:ut},computed:{componentName(){return this.$props.component==="users"?"UserTableDashboard":this.$props.component==="incidents"?"IncidentTable":this.$props.component==="activeUsers"?"ActiveUsers":"NotFound"}}},gt={class:"col card p-0 m-3"},mt={class:"card-header bg-white"},yt=e("div",{class:"card-title ps-2"},null,-1),_t={class:"card-body text-center"};function ft(t,s,p,m,d,r){return a(),c("div",gt,[e("div",mt,[e("h4",null,i(p.cardTitle),1)]),yt,e("div",_t,[(a(),C(D(r.componentName)))])])}const wt=_(pt,[["render",ft]]),bt={name:"DashboardGrid",components:{DashboardCard:wt},computed:{isAdmin(){return localStorage.getItem("isAdmin")==="true"}}},Ut={class:"container text-center"},kt={class:"row"},Bt={key:0,class:"row mt-3"};function It(t,s,p,m,d,r){const o=S("DashboardCard");return a(),c("div",Ut,[e("div",kt,[g(o,{"card-title":"Latest Incidents",component:"incidents"}),g(o,{"card-title":"Recent Activities",component:"notfound"})]),r.isAdmin?(a(),c("div",Bt,[g(o,{"card-title":"Active Users",component:"activeUsers"}),g(o,{"card-title":"Failed Logins",component:"notfound"})])):E("",!0)])}const $t=_(bt,[["render",It]]),vt={class:"bg-success-subtle text-dark text-center mt-2 mb-2 rounded-4"},St={__name:"Dashboard_View",setup(t){const s=f(),p=s.token,m=s.userId,d=s.user,r=A("");return T(async()=>{const o=n.request({headers:{Authorization:`Bearer ${p}`},method:"GET",url:`/api/user/${m}`}).then(y=>{console.log(y.data)});r.value=o.data}),(o,y)=>(a(),c(w,null,[g(F),g(P,{msg:"Dashboard",destination:"/incidents/create",buttonText:"Report new Incident"}),e("h3",vt,[k("Welcome "),e("strong",null,i(L(d)),1),k(", let's check some incidents today")]),g($t),g(N)],64))}};export{St as default};
