package com.mybar.music.util;

import android.media.MediaPlayer;

public class MusicPlayer {
	private static MediaPlayer mediaPlayer = getMedia();;

	public static MediaPlayer getMedia() {
		if (mediaPlayer == null) {
			// System.out.println("321321");
			mediaPlayer = new MediaPlayer();
			// System.out.println("123123");
		}
		return mediaPlayer;
	}

	/**
	 * 本地播放方法
	 * 
	 * @param path
	 */
	public void playFromLocal(String path) {

		try {
			// System.out.println("aaaaa");
			mediaPlayer.reset();
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
			mediaPlayer.start();

			/**
			 * 自动播放下一首
			 */
			mediaPlayer
					.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							// Mp3Thread.state = Final.DOWN;//
							// 给线程类的state设置参数为下一首
						}
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * 在线播放
	 * 
	 * @param path
	 */
	public void playFromInternet(String path) {

		try {
			mediaPlayer.reset();
			mediaPlayer.setDataSource(path);
			mediaPlayer.prepare();
			mediaPlayer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * 暂停方法
	 * 
	 * @return
	 */
	public boolean Pause() {
		if (mediaPlayer.isPlaying()) {
			mediaPlayer.pause();
			return true;
		} else {
			mediaPlayer.start();
			return false;
		}
	}

	/**
	 * 得到当前的播放时间
	 */
	public int GetPlayerTime() {
		return mediaPlayer.getCurrentPosition();// 得到当前歌曲的播放时间
	}

	public void SeektoMusic(int time) {
		mediaPlayer.seekTo(time);

		mediaPlayer.start();
	}

}
