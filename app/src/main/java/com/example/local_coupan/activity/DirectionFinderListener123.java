package com.example.local_coupan.activity;

import com.example.local_coupan.Modules.Route;

import java.util.List;

public interface DirectionFinderListener123 {
    void onDirectionFinderStart();
    void onDirectionFinderSuccess(List<Route> route);
}
