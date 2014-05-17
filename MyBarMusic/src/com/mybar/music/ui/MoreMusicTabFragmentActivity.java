package com.mybar.music.ui;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mybar.music.R;

public class MoreMusicTabFragmentActivity extends FragmentActivity {@Override
	protected void onCreate(Bundle savedInstanceState) {

	super.onCreate(savedInstanceState);

	FragmentManager fm = getSupportFragmentManager();
	if (fm.findFragmentById(android.R.id.content) == null) {
		MoreMusicTabFragment moreMusicTabFragment = new MoreMusicTabFragment();
		fm.beginTransaction().add(android.R.id.content, moreMusicTabFragment)
				.commit();
	}
}

public static class MoreMusicTabFragment extends Fragment {
	private TextView textView1 = null;
	private TextView textView2 = null;
	private MoreMusicTabFragmentBroadcastReceiver receiver;
	private IntentFilter intentFilter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.mymusic_tab, container, false);
		textView1 = (TextView) v.findViewById(R.id.textView1);
		textView1.setText("MoreMusicTab TextView1");
		textView2 = (TextView) v.findViewById(R.id.textView2);
		textView2.setText("MoreMusicTab TextView2");

		return v;
	}

	@Override
	public void onPause() {

		super.onPause();
		getActivity().unregisterReceiver(receiver);
	}

	@Override
	public void onResume() {

		super.onResume();
		receiver = new MoreMusicTabFragmentBroadcastReceiver();
		getActivity().registerReceiver(receiver, getIntentFilter());
	}

	private IntentFilter getIntentFilter() {
		if (intentFilter == null) {
			intentFilter = new IntentFilter();
			intentFilter.addAction("TAB1_ACTION");
		}
		return intentFilter;
	}

	class MoreMusicTabFragmentBroadcastReceiver extends BroadcastReceiver {

		@Override
		public void onReceive(Context context, Intent intent) {
			if (intent.getAction().equals("TAB1_ACTION")) {
				textView1.setText("Received!");
			}
		}

	}
}
}

