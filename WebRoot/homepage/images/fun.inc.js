/*首页产品展示插件*/
eval(function(E,I,A,D,J,K,L,H){function C(A){return A<62?String.fromCharCode(A+=A<26?65:A<52?71:-4):A<63?'_':A<64?'$':C(A>>6)+C(A&63)}while(A>0)K[C(D--)]=I[--A];function N(A){return K[A]==L[A]?A:K[A]}if(''.replace(/^/,String)){var M=E.match(J),B=M[0],F=E.split(J),G=0;if(E.indexOf(F[0]))F=[''].concat(F);do{H[A++]=F[G++];H[A++]=N(B)}while(B=M[G]);H[A++]=F[G]||'';return H.join('')}return E.replace(J,N)}('(z(O){O.8=O.8||{};O.8={U:{Bj:"K",BI:"current",7:L,BV:"Bt",Bc:L.M,Bx:"Bq",l:M,x:M,BO:L.B0,Bl:"swing",5:k,2:k,By:k,_:Bg,4:Bg,T:k},BH:z(O,N){A[O]=N}};R A={"Bq":z(N,O){W.6().BU();W.$(N).show();O.i()},ajax:z(N,O){W.6().first().load(W.9().BE(N).BZ("c"),O)}};z N(G,B,F){R E=W,D=O(W),C,N=G.q-M;O.X(F,z(N,A){P(O.Bo(A))D.a(N,A)});O.r(W,{j:z(H,B){R N=G.BE(H);P(v H=="string"&&H.Bi("#","")){N=G.filter("[c*="+H.Bi("#","")+"]");H=BQ.max(N.index(),L)}B=B||O.Event();B.e="_";D.y(B,[H]);P(B.Bh())p;A[F.Bx].i(E,H,z(){B.e="4";D.y(B,[H])});B.e="onStart";D.y(B,[H]);P(B.Bh())p;C=H;G.removeClass(F.BI);N.Bd(F.BI);p E},u:z(){p F},9:z(){p G},6:z(){p B},$:z(O){p E.6().o(O*F.l,(O+M)*F.l)},Bu:z(){p C},f:z(O){P(B.s().BN(":BF")||B.q<=F.x)p E;P(v O=="BB"){P(O<L)p F.5?E.j(N):E;Z P(O>N)p F.5?E.j(L):E;Z p E.j(O)}Z p E.j()},d:z(){p E.f(C+M)},Ba:z(){p E.f(C-M)},a:z(O,N){D.a(O,N);p E},Bp:z(O){D.Bp(O);p E},_:z(O){p W.a("_",O)},4:z(O){p W.a("4",O)},BK:z(O){}});R H;G.X(z(N){P(F.BV==="Bt")O(W).a({mouseenter:z(O){P(N!==C)H=BD(z(){E.j(N,O)},F.Bc*b)},mouseleave:z(){Br(H)}});Z O(W).a("j",z(O){P(N!==C)E.j(N,O);p k})});P(Bm.Bn)E.j(Bm.Bn);Z P(F.7===L||F.7>L)E.j(F.7);B.BM("K[c^=#]").j(z(N){E.j(O(W).BZ("c"),N)});P(F.By)B.S("cursor","pointer").j(z(){E.d();p k})}O.Q.8=z(C,E){R B=W.BE(v E=="BB"?E:L).g("8");P(B)p B;P(O.Bo(E))E={_:E};R A=O.r({},O.8.U),D=W.q;E=O.r(A,E);W.X(z(I){R F=O(W),A=C.jquery?C:F.Bv(C);P(!A.q)A=D==M?O(C):F.s().BM(C);R H=F.BM(E.Bj);P(!H.q){R G=BQ.ceil(A.q/E.l);for(I=M;I<=G;I++)O("<K>",{c:"javascript:void(L);",target:"_self",text:I}).appendTo(F);H=F.Bv("K")}B=new N(H,A,E);F.g("8",B)});p E.T?B:W}})(w);(z(N){R O=N.8;O.t=O.t||{};O.t.3={U:{3:Y,1:Bb,Bk:Y,T:k}};N.Q.3=z(C){P(v C=="BB")C={1:C};R B=N.r({},O.t.3.U),A;N.r(B,C);W.X(z(){R D=N(W).8();P(D)A=D;R C,E,O=Y;D.BP=z(){P(C)p;O=k;C=setInterval(z(){D.d()},B.1*b);D.d()};D.BG=z(){C=clearInterval(C)};D.Bs=z(){D.BG();O=Y};P(B.Bk)D.6().hover(z(){D.BG();Br(E)},z(){P(!O)E=BD(D.BP,B.1*b)});P(B.3)BD(D.BP,B.1*b)});p B.T?A:W}})(w);(z(O){O.Q.carousel=z(){W.X(z(){R F=O(W).8(),G=F.u(),D=F.6(),A=D.s(),B=F.9().q-M,H=D.o(L,G.l),J=D.o(B*G.l),N=G.2?J.0().V:J.0().h,E=G.2?"V":"h",C=D.q>G.x,I=L;D.S("0","relative").X(z(){I+=G.2?O(W).outerHeight(Y):O(W).outerWidth(Y)});P(C&&J.q<G.x)A.append(D.o(L,G.x).BX().Bd("BX"));O.r(F,{f:z(O){P(A.BN(":BF")||!C)p W;P(O<L){W.BC(Y);p W.j(B)}Z P(O>B){W.BC(k);p W.j(L)}Z p W.j(O)},BC:z(A){R N=A?J:H;O.X(N,z(){O(W).S(E,A?-I:I+"Bw")})},BK:z(C){R B=C?J:H;O.X(B,z(){O(W).S(E,"0px")});A.S(E,C?-N:L+"Bw")}})});p W}})(w);(z(N){N.Q.m=z(O){p W[O?"a":"y"]("m",O)};N.n.special.m={setup:z(){N.n.add(W,A,O,{})},teardown:z(){N.n.remove(W,A,O)}};R A=!N.Bf.mozilla?"BL":"Bz"+(N.Bf.version<"M.B1"?" Be":"");z O(O){switch(O.e){BJ"Be":p N.r(O.g,{BY:O.BY,BW:O.BW,BR:O.BR,BS:O.BS});BJ"Bz":N.r(O,O.g);O.BA=-O.detail/Bb;BT;BJ"BL":O.BA=O.wheelDelta/120;BT}O.e="m";p N.n.handle.i(W,O,O.BA)}N.Q.BL=z(){W.X(z(){R O=N(W).8();O.6().s().m(z(N,A){P(A<L)O.d();Z O.Ba();p k})});p W}})(w);O.8.BH("fade",z(D,N){R A=W,C=A.u(),O=A.6(),B=A.$(D);O.BU();B.fadeIn(C.BO*b,N)});O.8.BH("scroll",z(I,A){R D=W,G=D.u(),F=D.$(I),O=D.6().s(),C=D.Bu(),E=D.9().q-M,N=(C===L&&I===E)||(C===E&&I===L),H=(C===L&&I===E)?Y:k,B=G.2?{V:-F.0().V}:{h:-F.0().h};P(O.BN(":BF"))O.Bs(Y);O.animate(B,G.BO*b,G.Bl,z(){A.i();P(N)D.BK(H)})})','a|0|1|_|$|if|fn|var|css|api|cfg|top|this|each|true|else|bind|1000|href|next|type|move|data|left|call|click|false|steps|wheel|event|slice|return|length|extend|parent|plugin|getCfg|typeof|jQuery|visible|trigger|function|position|interval|vertical|autoplay|onSwitch|circular|getPanels|initIndex|switchable|getTriggers|beforeSwitch|getVisiblePanel|delta|number|adjustPosition|setTimeout|eq|animated|pause|addEffect|currentCls|case|resetPosition|mousewheel|find|is|speed|play|Math|pageX|pageY|break|hide|triggerType|clientY|clone|clientX|attr|prev|3|delay|addClass|mousemove|browser|null|isDefaultPrevented|replace|triggers|autopause|easing|location|hash|isFunction|unbind|default|clearTimeout|stop|mouse|getIndex|children|px|effect|panelSwitch|DOMMouseScroll|7|9'.split('|'),108,117,/[\w\$]+/g,{},{},[]));
/*圆角插件*/
(function($){var style=document.createElement('div').style,moz=style['MozBorderRadius']!==undefined,webkit=style['WebkitBorderRadius']!==undefined,radius=style['borderRadius']!==undefined||style['BorderRadius']!==undefined,mode=document.documentMode||0,noBottomFold=$.browser.msie&&(($.browser.version<8&&!mode)||mode<8),expr=$.browser.msie&&(function(){var div=document.createElement('div');try{div.style.setExpression('width','0+0');div.style.removeExpression('width')}catch(e){return false};return true})();$.support=$.support||{};$.support.borderRadius=moz||webkit||radius;function sz(el,p){return parseInt($.css(el,p))||0};function hex2(s){s=parseInt(s).toString(16);return(s.length<2)?'0'+s:s};function gpc(node){while(node){var v=$.css(node,'backgroundColor'),rgb;if(v&&v!='transparent'&&v!='rgba(0, 0, 0, 0)'){if(v.indexOf('rgb')>=0){rgb=v.match(/\d+/g);return'#'+hex2(rgb[0])+hex2(rgb[1])+hex2(rgb[2])};return v};if(node.nodeName.toLowerCase()=='html')break;node=node.parentNode};return'#ffffff'};function getWidth(fx,i,width){switch(fx){case'round':return Math.round(width*(1-Math.cos(Math.asin(i/width))));case'cool':return Math.round(width*(1+Math.cos(Math.asin(i/width))));case'sharp':return width-i;case'bite':return Math.round(width*(Math.cos(Math.asin((width-i-1)/width))));case'slide':return Math.round(width*(Math.atan2(i,width/i)));case'jut':return Math.round(width*(Math.atan2(width,(width-i-1))));case'curl':return Math.round(width*(Math.atan(i)));case'tear':return Math.round(width*(Math.cos(i)));case'wicked':return Math.round(width*(Math.tan(i)));case'long':return Math.round(width*(Math.sqrt(i)));case'sculpt':return Math.round(width*(Math.log((width-i-1),width)));case'dogfold':case'dog':return(i&1)?(i+1):width;case'dog2':return(i&2)?(i+1):width;case'dog3':return(i&3)?(i+1):width;case'fray':return(i%2)*width;case'notch':return width;case'bevelfold':case'bevel':return i+1;case'steep':return i/2+1;case'invsteep':return(width-i)/2+1}};$.fn.corner=function(options){if(this.length==0){if(!$.isReady&&this.selector){var s=this.selector,c=this.context;$(function(){$(s,c).corner(options)})};return this};return this.each(function(index){var $this=$(this),o=[$this.attr($.fn.corner.defaults.metaAttr)||'',options||''].join(' ').toLowerCase(),keep=/keep/.test(o),cc=((o.match(/cc:(#[0-9a-f]+)/)||[])[1]),sc=((o.match(/sc:(#[0-9a-f]+)/)||[])[1]),width=parseInt((o.match(/(\d+)px/)||[])[1])||10,re=/round|bevelfold|bevel|notch|bite|cool|sharp|slide|jut|curl|tear|fray|wicked|sculpt|long|dog3|dog2|dogfold|dog|invsteep|steep/,fx=((o.match(re)||['round'])[0]),fold=/dogfold|bevelfold/.test(o),edges={T:0,B:1},opts={TL:/top|tl|left/.test(o),TR:/top|tr|right/.test(o),BL:/bottom|bl|left/.test(o),BR:/bottom|br|right/.test(o)},strip,pad,cssHeight,j,bot,d,ds,bw,i,w,e,c,common,$horz;if(!opts.TL&&!opts.TR&&!opts.BL&&!opts.BR)opts={TL:1,TR:1,BL:1,BR:1};if($.fn.corner.defaults.useNative&&fx=='round'&&(radius||moz||webkit)&&!cc&&!sc){if(opts.TL)$this.css(radius?'border-top-left-radius':moz?'-moz-border-radius-topleft':'-webkit-border-top-left-radius',width+'px');if(opts.TR)$this.css(radius?'border-top-right-radius':moz?'-moz-border-radius-topright':'-webkit-border-top-right-radius',width+'px');if(opts.BL)$this.css(radius?'border-bottom-left-radius':moz?'-moz-border-radius-bottomleft':'-webkit-border-bottom-left-radius',width+'px');if(opts.BR)$this.css(radius?'border-bottom-right-radius':moz?'-moz-border-radius-bottomright':'-webkit-border-bottom-right-radius',width+'px');return};strip=document.createElement('div');$(strip).css({overflow:'hidden',height:'1px',minHeight:'1px',fontSize:'1px',backgroundColor:sc||'transparent',borderStyle:'solid'});pad={T:parseInt($.css(this,'paddingTop'))||0,R:parseInt($.css(this,'paddingRight'))||0,B:parseInt($.css(this,'paddingBottom'))||0,L:parseInt($.css(this,'paddingLeft'))||0};if(typeof this.style.zoom!=undefined)this.style.zoom=1;if(!keep)this.style.border='none';strip.style.borderColor=cc||gpc(this.parentNode);cssHeight=$(this).outerHeight();for(j in edges){bot=edges[j];if((bot&&(opts.BL||opts.BR))||(!bot&&(opts.TL||opts.TR))){strip.style.borderStyle='none '+(opts[j+'R']?'solid':'none')+' none '+(opts[j+'L']?'solid':'none');d=document.createElement('div');$(d).addClass('jquery-corner');ds=d.style;bot?this.appendChild(d):this.insertBefore(d,this.firstChild);if(bot&&cssHeight!='auto'){if($.css(this,'position')=='static')this.style.position='relative';ds.position='absolute';ds.bottom=ds.left=ds.padding=ds.margin='0';if(expr)ds.setExpression('width','this.parentNode.offsetWidth');else ds.width='100%'}else if(!bot&&$.browser.msie){if($.css(this,'position')=='static')this.style.position='relative';ds.position='absolute';ds.top=ds.left=ds.right=ds.padding=ds.margin='0';if(expr){bw=sz(this,'borderLeftWidth')+sz(this,'borderRightWidth');ds.setExpression('width','this.parentNode.offsetWidth - '+bw+'+ "px"')}else ds.width='100%'}else{ds.position='relative';ds.margin=!bot?'-'+pad.T+'px -'+pad.R+'px '+(pad.T-width)+'px -'+pad.L+'px':(pad.B-width)+'px -'+pad.R+'px -'+pad.B+'px -'+pad.L+'px'};for(i=0;i<width;i++){w=Math.max(0,getWidth(fx,i,width));e=strip.cloneNode(false);e.style.borderWidth='0 '+(opts[j+'R']?w:0)+'px 0 '+(opts[j+'L']?w:0)+'px';bot?d.appendChild(e):d.insertBefore(e,d.firstChild)};if(fold&&$.support.boxModel){if(bot&&noBottomFold)continue;for(c in opts){if(!opts[c])continue;if(bot&&(c=='TL'||c=='TR'))continue;if(!bot&&(c=='BL'||c=='BR'))continue;common={position:'absolute',border:'none',margin:0,padding:0,overflow:'hidden',backgroundColor:strip.style.borderColor};$horz=$('<div/>').css(common).css({width:width+'px',height:'1px'});switch(c){case'TL':$horz.css({bottom:0,left:0});break;case'TR':$horz.css({bottom:0,right:0});break;case'BL':$horz.css({top:0,left:0});break;case'BR':$horz.css({top:0,right:0});break};d.appendChild($horz[0]);var $vert=$('<div/>').css(common).css({top:0,bottom:0,width:'1px',height:width+'px'});switch(c){case'TL':$vert.css({left:width});break;case'TR':$vert.css({right:width});break;case'BL':$vert.css({left:width});break;case'BR':$vert.css({right:width});break};d.appendChild($vert[0])}}}}})};$.fn.uncorner=function(){if(radius||moz||webkit)this.css(radius?'border-radius':moz?'-moz-border-radius':'-webkit-border-radius',0);$('div.jquery-corner',this).remove();return this};$.fn.corner.defaults={useNative:true,metaAttr:'data-corner'}})(jQuery);
/*IE6png透明*/
(function($){var jspath=$('script').last().attr('src');var basepath='';if(jspath.indexOf('/')!=-1){basepath+=jspath.substr(0,jspath.lastIndexOf('/')+1);}$.fn.fixpng=function(options){function _fix_img_png(el,emptyGIF){var images=$('img[src*="png"]',el||document),png;images.each(function(){png=this.src;width=this.width;height=this.height;this.src=emptyGIF;this.width=width;this.height=height;this.style.filter="progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+png+"',sizingMethod='scale')";});}function _fix_bg_png(el){var bg=$(el).css('background-image');if(/url\([\'\"]?(.+\.png)[\'\"]?\)/.test(bg)){var src=RegExp.$1;$(el).css('background-image','none');$(el).css("filter","progid:DXImageTransform.Microsoft.AlphaImageLoader(src='"+src+"',sizingMethod='scale')");}}if($.browser.msie&&$.browser.version<7){return this.each(function(){var opts={scope:'',emptyGif:basepath+'blank.gif'};$.extend(opts,options);switch(opts.scope){case'img':_fix_img_png(this,opts.emptyGif);break;case'all':_fix_img_png(this,opts.emptyGif);_fix_bg_png(this);break;default:_fix_bg_png(this);break;}});}}})(jQuery);
//全局函数
function pressCaptcha(obj){obj.value=obj.value.toUpperCase()};function ResumeError(){return true};window.onerror=ResumeError;function SetHome(obj,vrl){try{obj.style.behavior='url(#default#homepage)';obj.setHomePage(vrl)}catch(e){if(window.netscape){try{netscape.security.PrivilegeManager.enablePrivilege("UniversalXPConnect")}catch(e){alert("Your Browser does not support")};var prefs=Components.classes['@mozilla.org/preferences-service;1'].getService(Components.interfaces.nsIPrefBranch);prefs.setCharPref('browser.startup.homepage',vrl)}}};function addFavorite(){var vDomainName=window.location.href;var description=document.title;try{window.external.AddFavorite(vDomainName,description)}catch(e){window.sidebar.addPanel(description,vDomainName,"")}};function metHeight(group){tallest=0;group.each(function(){thisHeight=$(this).height();if(thisHeight>tallest){tallest=thisHeight}});group.height(tallest)};function metmessagesubmit(info3,info4){if(document.myform.pname.value.length==0){alert(info3);document.myform.pname.focus();return false};if(document.myform.info.value.length==0){alert(info4);document.myform.info.focus();return false}};function addlinksubmit(info2,info3){if(document.myform.webname.value.length==0){alert(info2);document.myform.webname.focus();return false};if(document.myform.weburl.value.length==0||document.myform.weburl.value=='http://'){alert(info3);document.myform.weburl.focus();return false}};function textWrap(my){var text='',txt=my.text();txt=txt.split("");for(var i=0;i<txt.length;i++){text+=txt[i]+'<br/>'};my.html(text)}
//以上JS代码不建议去除，尤其是全局函数。
/*模板定义函数*/
function proxy(dom,lei,type){
	if(dom){
		dom.hover(function(){
			$(this).addClass(lei);
			if(type==1){
				if($(this).find('.sub').length>0){
					$(this).find('.sub').show()
				}
				else{
					$(this).addClass(lei+'er')
				}
			}
		}
		,function(){
			$(this).removeClass(lei);
			if(type==1){
				if($(this).find('.sub').length>0){
					$(this).find('.sub').hide()
				}
				else{
					$(this).removeClass(lei+'er');
				}
			}
		})
	}
}
function navnow(dom,part2,part3,none){
	var li=dom.find(".navnow dt[id*='part2_']");
	var dl=li.next("dd.sub");
	if(none)dl.hide();
	if(part2.next("dd.sub").length>0)part2.next("dd.sub").show();
	if(part3.length>0)part3.parent('dd.sub').show();
	li.bind('click',function(){
		var fdl=$(this).next("dd.sub");
		if(fdl.length>0){
			fdl.is(':hidden')?fdl.show():fdl.hide();
			fdl.is(':hidden')?$(this).removeClass('launched'):$(this).addClass('launched');
		}
	})
}
function partnav(c2,c3,jsok){
	var part2=$('#part2_'+c2);
	var part3=$('#part3_'+c3);
	if(part2)part2.addClass('on');
	if(part3)part3.addClass('on');
	if(jsok!=0)navnow($('#sidebar'),part2,part3);
}
function DownWdith(group){
	tallest=0;
	group.each(function(){
		thisWdith=$(this).width();
		if(thisWdith>tallest){
			tallest=thisWdith
		}
	});
	group.width(tallest);
}
function Iframedom(){
	var Iframe=$("#iframe");
	var Iframe_Conts=Iframe.contents().find("body");
	Iframe_Conts.css("height","100%");
	var Iframe_div=Iframe_Conts.find("div.main_deng");
	var Iframe_div1=Iframe_Conts.find("div.main_zhuce");
	Iframe_div.css("margin","0px auto");
	Iframe_div1.css("margin","0px auto");
	var Iframe_Height=Iframe_Conts.outerHeight(true);
	Iframe.height(Iframe_Height);
}
function productlist(dom,l){
	var w=dom.width();
	var p=((w/l)-dom.find('li').width())/2;
	if(p<0)p=0;
	dom.find('li').css("margin","0px "+p+"px");
}
/*自定义函数结束*/
//以下为执行代码
var module=Number($("footer").attr('data-module')),classnow=Number($("footer").attr('data-classnow'));
if(module){//全部页面
	$("nav li:first").addClass('myCorner').attr({'data-corner':'tl 5px'});//圆角
	$("nav li:last").addClass('myCorner').attr({'data-corner':'tr 5px'});//圆角
	$("#web_logo,nav ul li a").bind("focus",function(){if(this.blur)this.blur();});//IE
	proxy($("nav ul li[class!='line']"),'hover');//鼠标经过导航
}
if(module!=10001){//所有内页
	var csnow=$("#sidebar").attr('data-csnow'),class3=$("#sidebar").attr('data-class3'),jsok=$("#sidebar").attr('data-jsok');
	partnav(csnow,class3,jsok);//侧栏导航点击展开隐藏
}
switch(module){
	case 10001://首页
		$('.dl-jqrun dl').each(function(){//首页成功案例区块排版
			var dt = $(this).find('dt');
			var dd = $(this).find('dd');
			var wt = $(this).width()-dt.width();
				dd.width(wt);
			var ht = dt.height()>dd.height()?dt.height():dd.height();
				dd.height(ht);
				dt.height(ht);
		});
		metHeight($(".contour-1"));//等高
		metHeight($(".contour-2"));
		//产品展示
		if($("#indexcar ol li").size()>0){
			$("#indexcar li h3").width($("#indexcar li img").width());
			$("#indexcar li").height($("#indexcar li").height());
			$("#indexcar ol").height($("#indexcar li").height());
			$("#indexcar").height($("#indexcar ol").height());
			var listnum = $("#indexcar").attr('data-listnum');
			productlist($("#indexcar"),listnum);
			$("#trigger").switchable("#indexcar > ol > li", {
				triggerType: "click",effect: "scroll",steps:1,visible:listnum
			}).autoplay().carousel();
			var api4 = $("#trigger").switchable();
			$("#car_next").click(function(){api4.next();});
			$("#car_prev").click(function(){api4.prev();});
		}
	break;
	case 3://产品模块
		var plist = $('#productlist');
		if(plist.size()>0){
			metHeight(plist.find('li'));
		}else{
			var pshow=$(".pshow");
			var pshow_ddwh=pshow.width()-pshow.find("dt").width();
			pshow.find("dd").width(pshow_ddwh);
			var parlt=$('.pshow dd li');
			parlt.each(function(){
				var parst=$(this).find('span');
				if(parst.height()<$(this).height())parst.height($(this).height());
			});
		}
	break;
	case 4://下载模块
		var showdownload = $('#showdownload');
		if(showdownload.size()>0){
			var parlt=$('.paralist li');
			parlt.each(function(){
				var parst=$(this).find('span');
				if(parst.height()<$(this).height())parst.height($(this).height());
			});
			DownWdith($('.paralist li span'));
			$('.paralist li:last').css("border-bottom","0");
		}
	break;
	case 5://图片模块
		var ilist = $('#imglist');
		if(ilist.size()>0){
			metHeight(ilist.find('li'));
		}
	break;
}
$('.myCorner').corner();//圆角
var ie6 = (navigator.appName == "Microsoft Internet Explorer" && parseInt(navigator.appVersion) == 4 && navigator.appVersion.indexOf("MSIE 6.0") != -1);
if (jQuery.browser.msie && ie6){
	$(document.body).fixpng({scope:'img'});
}