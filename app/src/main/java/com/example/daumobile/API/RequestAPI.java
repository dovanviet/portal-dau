package com.example.daumobile.API;

import com.example.daumobile.Model.Point;
import com.example.daumobile.Model.Program;
import com.example.daumobile.Model.Schedule;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface RequestAPI {
    @GET("portal_dau/getPoint.php/")
    Call<ArrayList<Point>> getPoint();

    @GET("portal_dau/getProgram.php/")
    Call<ArrayList<Program>> getProgram();

    @GET("portal_dau/getSchedule.php/")
    Call<ArrayList<Schedule>> getSchedule();
}
