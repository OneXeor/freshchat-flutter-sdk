package com.fc.sampleobjc.flutter_app;

import android.os.Bundle;

import androidx.annotation.Nullable;

import com.freshchat.consumer.sdk.FaqOptions;
import com.freshchat.consumer.sdk.Freshchat;
import com.freshchat.consumer.sdk.FreshchatConfig;

import io.flutter.embedding.android.FlutterActivity;

public class MainActivity extends FlutterActivity {

    final String appId = "2bedb838-81d9-47e5-9b66-fa0989b7ab58";
    final String appKey = "b9a14cf7-7c62-4dc4-8cbe-0ed069c46ca4";

    final String appIdFreshSales = "1c587bae-d2c1-4ff1-9e3f-6256d6171b19";
    final String appKeyFreshSales = "36691a24-94f1-4212-a879-41ee0897c01a";

    final String domain = "msdk.eu.freshchat.com";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        findViewById(R.id.init_freshdesk).setOnClickListener(v -> {
            FreshchatConfig freshchatConfig = new FreshchatConfig(appId, appKey);
            freshchatConfig.setDomain(domain);
            freshchatConfig.setResponseExpectationEnabled(true);
            freshchatConfig.setTeamMemberInfoVisible(true);
            freshchatConfig.setGallerySelectionEnabled(true);
            freshchatConfig.setUserEventsTrackingEnabled(true);
            freshchatConfig.setCameraCaptureEnabled(true);
            freshchatConfig.setFileSelectionEnabled(true);
            Freshchat.getInstance(getApplicationContext()).init(freshchatConfig);
        });
        findViewById(R.id.init_freshsales).setOnClickListener(v -> {
            FreshchatConfig freshchatConfig = new FreshchatConfig(appIdFreshSales, appKeyFreshSales);
            freshchatConfig.setDomain(domain);
            freshchatConfig.setResponseExpectationEnabled(true);
            freshchatConfig.setTeamMemberInfoVisible(true);
            freshchatConfig.setGallerySelectionEnabled(true);
            freshchatConfig.setUserEventsTrackingEnabled(true);
            freshchatConfig.setCameraCaptureEnabled(true);
            freshchatConfig.setFileSelectionEnabled(true);
            Freshchat.getInstance(getApplicationContext()).init(freshchatConfig);
        });

        findViewById(R.id.open_freshworks).setOnClickListener(v -> {
            FaqOptions faqOptions = new FaqOptions();
            Freshchat.showFAQs(getApplicationContext(), faqOptions);
        });
    }
}
