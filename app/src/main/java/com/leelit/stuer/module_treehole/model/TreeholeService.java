package com.leelit.stuer.module_treehole.model;

import com.leelit.stuer.bean.TreeholeComment;
import com.leelit.stuer.bean.TreeholeInfo;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by Leelit on 2016/3/24.
 */
public interface TreeholeService {

    @POST("create")
    Observable<ResponseBody> addRecord(@Body TreeholeInfo info);

    @Multipart
    @POST("create/photo")
    Observable<ResponseBody> addRecordWithPhoto(@Part("photo") RequestBody photo, @Part("info") TreeholeInfo info);

    @GET("query")
    Observable<List<TreeholeInfo>> getNewerData(@Query("newer") String newer);

    @GET("like")
    Observable<ResponseBody> doLikeJob(@Query("uniquecode") String uniquecode, @Query("imei") String imei, @Query("islike") String isLike);

    @GET("unlike")
    Observable<ResponseBody> doUnlikeJob(@Query("uniquecode") String uniquecode, @Query("imei") String imei, @Query("isunlike") String isUnlike);

    @POST("comment")
    Observable<ResponseBody> sendComment(@Body TreeholeComment.Comment comment);

    @GET("comment")
    Observable<TreeholeComment> loadComments(@Query("uniquecode") String uniquecode);
}
