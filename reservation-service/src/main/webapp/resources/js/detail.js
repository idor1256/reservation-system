var $btn_prev = $('.btn_prev');
var $btn_nxt = $('.btn_nxt');
var $btn_detail = $('._detail');
var $btn_path = $('._path');
var $btn_more_open = $('._open');
var $btn_more_close = $('._close');

var ImageSlide = (function(){
	var $productImages = $(".visual_img");
	var movePx = 414;

	function prevSlide(){
		var lastList = $productImages.find('>.item:last-child').clone(true);
		lastList.prependTo($productImages);
		$productImages.css("left", "-"+movePx+"px");
		$productImages.find(">.item:last-child").remove();
		$productImages.animate({left: '0'}, "slow");
	};
	function nxtSlide(){
		var firstList = $productImages.find(">.item:first-child").clone(true);
		firstList.appendTo($productImages);
		$productImages.find(">.item:first-child").remove();
		$productImages.css("left", "0");
		$productImages.animate({left: "-"+movePx+"px"}, "slow");
	};

	return {
		btnPrevEventListener : function(){
			prevSlide();
		},
		btnNxtEventListener : function(){
			nxtSlide();
		}
	};
})();

var BtnMore = (function(){
  var $store_details = $('.store_details');

  return {
    moreOpen : function(){
      $store_details.removeClass("close3");
      $btn_more_close.css("display", "block");
      $btn_more_open.css("display", "none");
    },
    moreClose : function(){
      $store_details.addClass("close3");
      $btn_more_open.css("display", "block");
      $btn_more_close.css("display", "none");
    }
  }
})();

var DetailArea = (function(){
  var $detail_area_wrap = $('.detail_area_wrap');
  var $detail_location = $('.detail_location');

  return {
    btnDetail : function(){
      $btn_path.find(">.anchor").removeClass("active");
      $btn_detail.find(">.anchor").addClass("active");
      $detail_area_wrap.removeClass("hide");
      $detail_location.addClass("hide");
    },
    btnPath : function(){
      $btn_detail.find(">.anchor").removeClass("active");
      $btn_path.find(">.anchor").addClass("active");
      $detail_area_wrap.addClass("hide");
      $detail_location.removeClass("hide");
    }
  }
})();

var GetFromServer = (function(){
	var product_id = window.location.pathname.split("/")[2];
	var source = $("#product-list").html();
	var template = Handlebars.compile(source);

	function countImages(){
		$.ajax({
			url : "/api/images/count/" + product_id,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				$(".figure_pagination>.off>span").text(data);
			}
		});
	}
	function countComments(){
		$.ajax({
			url : "/api/comments/products/count/" + product_id,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){
				$(".grade_area>.join_count>.green").text(data+"건");
			}
		});
	}

	functions comments(){
		$.ajax({
			url : "/api/comments/products/" + product_id,
			method : "get",
			processData : true,
			contentType : "application/json; charset=UTF-8",
			success : function(data){

			}
		});
	}

	return {
		images : function(){
			countImages();
		},
		comments : function(){
			countComments();
			commnets();
		}
	}
})();

$(document).ready(function (){
	$btn_prev.on("click", ImageSlide.btnPrevEventListener);
	$btn_nxt.on("click", ImageSlide.btnNxtEventListener);

	$btn_more_open.on("click", BtnMore.moreOpen);
	$btn_more_close.on("click", BtnMore.moreClose);

	$btn_detail.on("click", DetailArea.btnDetail);
	$btn_path.on("click", DetailArea.btnPath);

	GetFromServer.images();
	GetFromServer.comments();
});
