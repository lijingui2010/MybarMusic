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
	 * ���ز��ŷ���
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
			 * �Զ�������һ��
			 */
			mediaPlayer
					.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

						public void onCompletion(MediaPlayer mp) {
							// TODO Auto-generated method stub
							// Mp3Thread.state = Final.DOWN;//
							// ���߳����state���ò���Ϊ��һ��
						}
					});
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/*
	 * ���߲���
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
	 * ��ͣ����
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
	 * �õ���ǰ�Ĳ���ʱ��
	 */
	public int GetPlayerTime() {
		return mediaPlayer.getCurrentPosition();// �õ���ǰ�����Ĳ���ʱ��
	}

	public void SeektoMusic(int time) {
		mediaPlayer.seekTo(time);

		mediaPlayer.start();
	}

}
