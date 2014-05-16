(ns sd5342)
 (try  (do ) (catch Exception e "Exception happened"))

(defn render [params]
(let [blocks [ (str "<!--================================================== -->
  <body class="maubody1">
<div class="le">  

")
 (str "

   <header class="navbar navbar-static-top top">
  <div class="container">       
      <ul class="nav navbar-nav">
        <li>
          <a href="#" class="black">Blog</a>
        </li>
        <li>
          <a href="#" class="black">About</a>
        </li>       
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="trangngontinh.com/dangtruyen" class="orange">Đăng Truyện</a></li>
        <li><a href="#" class="orange" id="hiendangnhap">Đăng Nhập</a>
            <div class="anHien dangnhap whiteBgr" id="dangnhapblock">
              <form class="form-signin">        
                <input type="email" class="form-control" id="nhapemail" placeholder="Nhập Email">
                <br>
                <input type="password" class="form-control" id="nhapmatkhau" placeholder="Nhập Mật Khẩu">
                <label class="checkbox"><input type="checkbox" value="remember-me"> Nhớ Thông Tin</label>
                <button class="btn btn-success" type="submit">Đăng Nhập</button>
              </form>
            </div>     
        </li>        
        <li><a href="trangngontinh.com/dangky" class="orange">Đăng Ký</a></li>
      </ul>
    
  </div>
</header>

<!--================================================== -->

  <div class="container">
    <div class="row-fluid orangebackground">
        <div class="span5">
            <br>
            <a href="trangngontinh.com" ><img src="[[((data :lib-path) :logo3)]]" class="imgFloat" width="360" height="130"></a>
        </div>
        <div class="span7">
            <div class="socialicon">
                <a href="#" ><img src="[[((data :lib-path) :facebook)]]" class="socialicon1" width="50" height="50"></a>
                <a href="#" ><img src="[[((data :lib-path) :twitter)]]" class="socialicon1" width="50" height="50"></a>
                <a href="#" ><img src="[[((data :lib-path) :rss)]]" class="socialicon1" width="50" height="50"></a> 
                <a href="#" ><img src="[[((data :lib-path) :google+)]]" class="socialicon1" width="50" height="50"></a> 
            </div>  
        </div>
    </div> 
  </div>


  <!--================================================== -->


   <div class="navbar-wrapper">
      <div class="container">
        <div class="navbar navbar-custom navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand " href="trangngontinh.com"><b>Trang Ngôn Tình</b></a>
            </div>
            <div class="collapse navbar-collapse bs-navbar-collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="trangngontinh.com">HOME</a></li>                
                <li><a href="trangngontinh.com/danhsachtruyen"><b>DANH SÁCH TRUYỆN</b></a></li>   
                <li><a href="trangngontinh.com/doctruyen"><b>ĐỌC TRUYỆN</b></a></li> 
                <li><a href="trangngontinh.com/englishnovel"><b>ENGLISH NOVEL</b></a></li>
                <li><a href="trangngontinh.com/timkiemnangcao"><b>TÌM TRUYỆN</b></a></li>              
                <li><a href="trangngontinh.com/dangtruyen"><b>GÓC SÁNG TÁC</b></a></li> 
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>




  <!--================================================== -->

<div class="container-fluid big-wrapper maubody">

    <div class="row-fluid">
      <div class="form-group form-inline col-xs-pull-2 bentrai2" style="float:right;">
          <input type="text" class="form-control" placeholder="Search ...">
          <button href="[[(data :tim)]]" type="submit" class="btn btn-default">Tìm</button>
          <a href = "trangngontinh.com/advancedsearch" class="btn btn-success" role="button">Tìm kiếm nâng cao</a>
      </div>
    </div>



    <!--================================================== -->






    </div><!--le-->

<header class="navbar navbar-static-top top">
  <div class="container">       
      <ul class="nav navbar-nav">
        <li>
          <a href="#" class="black">Blog</a>
        </li>
        <li>
          <a href="#" class="black">About</a>
        </li>       
      </ul>
      <ul class="nav navbar-nav navbar-right">
        <li><a href="trangngontinh.com/dangtruyen" class="orange">Đăng Truyện</a></li>
        <li><a href="#" class="orange" id="hiendangnhap">Đăng Nhập</a>
            <div class="anHien dangnhap whiteBgr" id="dangnhapblock">
              <form class="form-signin">        
                <input type="email" class="form-control" id="nhapemail" placeholder="Nhập Email">
                <br>
                <input type="password" class="form-control" id="nhapmatkhau" placeholder="Nhập Mật Khẩu">
                <label class="checkbox"><input type="checkbox" value="remember-me"> Nhớ Thông Tin</label>
                <button class="btn btn-success" type="submit">Đăng Nhập</button>
              </form>
            </div>     
        </li>        
        <li><a href="trangngontinh.com/dangky" class="orange">Đăng Ký</a></li>
      </ul>
    
  </div>
</header>

<!--================================================== -->

  <div class="container">
    <div class="row-fluid orangebackground">
        <div class="span5">
            <br>
            <a href="trangngontinh.com" ><img src="[[((data :lib-path) :logo3)]]" class="imgFloat" width="360" height="130"></a>
        </div>
        <div class="span7">
            <div class="socialicon">
                <a href="#" ><img src="[[((data :lib-path) :facebook)]]" class="socialicon1" width="50" height="50"></a>
                <a href="#" ><img src="[[((data :lib-path) :twitter)]]" class="socialicon1" width="50" height="50"></a>
                <a href="#" ><img src="[[((data :lib-path) :rss)]]" class="socialicon1" width="50" height="50"></a> 
                <a href="#" ><img src="[[((data :lib-path) :google+)]]" class="socialicon1" width="50" height="50"></a> 
            </div>  
        </div>
    </div> 
  </div>


  <!--================================================== -->


   <div class="navbar-wrapper">
      <div class="container">
        <div class="navbar navbar-custom navbar-static-top" role="navigation">
          <div class="container">
            <div class="navbar-header">
              <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".bs-navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand " href="trangngontinh.com"><b>Trang Ngôn Tình</b></a>
            </div>
            <div class="collapse navbar-collapse bs-navbar-collapse">
              <ul class="nav navbar-nav">
                <li class="active"><a href="trangngontinh.com">HOME</a></li>                
                <li><a href="trangngontinh.com/danhsachtruyen"><b>DANH SÁCH TRUYỆN</b></a></li>   
                <li><a href="trangngontinh.com/doctruyen"><b>ĐỌC TRUYỆN</b></a></li> 
                <li><a href="trangngontinh.com/englishnovel"><b>ENGLISH NOVEL</b></a></li>
                <li><a href="trangngontinh.com/timkiemnangcao"><b>TÌM TRUYỆN</b></a></li>              
                <li><a href="trangngontinh.com/dangtruyen"><b>GÓC SÁNG TÁC</b></a></li> 
              </ul>
            </div>
          </div>
        </div>

      </div>
    </div>




  <!--================================================== -->

<div class="container-fluid big-wrapper maubody">

    <div class="row-fluid">
      <div class="form-group form-inline col-xs-pull-2 bentrai2" style="float:right;">
          <input type="text" class="form-control" placeholder="Search ...">
          <button href="[[(data :tim)]]" type="submit" class="btn btn-default">Tìm</button>
          <a href = "trangngontinh.com/advancedsearch" class="btn btn-success" role="button">Tìm kiếm nâng cao</a>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->")
]]
(apply str blocks)))