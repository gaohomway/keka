/**
 * Created by JetBrains PhpStorm.
 * User: taoqili
 * Date: 12-01-08
 * Time: 下午2:52
 * To change this template use File | Settings | File Templates.
 */
var imageUploader = {}, flashObj = null, postConfig=[];
(function () {
    var g = $G,
        //ajax = parent.baidu.editor.ajax,
        maskIframe = g("maskIframe"); //tab遮罩层,用来解决flash和其他dom元素的z-index层级不一致问题
       // flashObj;                   //flash上传对象

    var flagImg = null, flashContainer;
    imageUploader.init = function (opt, callbacks) {
         
        createFlash(opt, callbacks);
        //var srcImg = editor.selection.getRange().getClosedNode();
        //if (srcImg) { }
        addScrollListener();
        
    };
    imageUploader.setPostParams = function(obj,index){
        if(index===undefined){
            utils.each(postConfig,function(config){
                config.data = obj;
            })
        }else{
            postConfig[index].data = obj;
        }
    };

    function insertImage(imgObjs) {
        editor.fireEvent('beforeInsertImage', imgObjs);
        editor.execCommand("insertImage", imgObjs);
    }

    /**
     * 延迟加载
     */
    function addScrollListener() {

    }

    function hideFlash() {
        flashObj = null;
        flashContainer.innerHTML = "";
    }
 
    /**
     * 找到id下具有focus类的节点并返回该节点下的某个属性
     * @param id
     * @param returnProperty
     */
    function findFocus(id, returnProperty) {
        var tabs = g(id).children,
            property;
        for (var i = 0, ci; ci = tabs[i++];) {
            if (ci.className == "focus") {
                property = ci.getAttribute(returnProperty);
                break;
            }
        }
        return property;
    }


    /**
     * 绑定图片等比缩放事件
     * @param percent  缩放比例
     */
    function addSizeChangeListener(percent) {
        var width = g("width"),
            height = g("height"),
            lock = g('lock');
        width.onkeyup = function () {
            if (!isNaN(this.value) && lock.checked) {
                height.value = Math.round(this.value / percent) || this.value;
            }
        };
        height.onkeyup = function () {
            if (!isNaN(this.value) && lock.checked) {
                width.value = Math.round(this.value * percent) || this.value;
            }
        }
    }

    /**
     * 创建flash实例
     * @param opt
     * @param callbacks
     */
    function createFlash(opt, callbacks) {
        /*var i18n = utils.extend({}, lang.flashI18n);
        //处理图片资源地址的编码，补全等问题
        for (var i in i18n) {
            if (!(i in {"lang":1, "uploadingTF":1, "imageTF":1, "textEncoding":1}) && i18n[i]) {
                i18n[i] = encodeURIComponent(editor.options.langPath + editor.options.lang + "/images/" + i18n[i]);
            }
        }*/
        //opt = utils.extend(opt, i18n, false);
        var option = {
            createOptions:{
                id:'flash',
                url:opt.flashUrl,
                width:opt.width,
                height:opt.height,
                errorMessage:'Flash插件初始化失败，请更新您的FlashPlayer版本之后重试！',
                wmode:browser.safari ? 'transparent' : 'window',
                ver:'10.0.0',
                vars:opt,
                container:opt.container
            }
        };
        flashContainer = $G(opt.container);
        option = utils.extend(option, callbacks, false);
        flashObj = new baidu.flash.imageUploader(option);
    }


    function toggleFlash(show) {
        if (flashContainer && browser.webkit) {
            flashContainer.style.left = show ? "0" : "-10000px";
        }
    }

    /**
     * 选择切换，传入一个container的ID
     * @param selectParentId
     */
    function switchSelect(selectParentId) {
        var select = g(selectParentId),
            children = select.children;
        domUtils.on(select, "click", function (evt) {
            var tar = evt.srcElement || evt.target;
            for (var j = 0, cj; cj = children[j++];) {
                cj.className = "";
                cj.removeAttribute && cj.removeAttribute("class");
            }
            tar.className = "focus";

        });
    }

})();
