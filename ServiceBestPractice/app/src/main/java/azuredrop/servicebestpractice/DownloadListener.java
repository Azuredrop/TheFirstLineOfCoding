package azuredrop.servicebestpractice;

/**
 * Created by Administrator on 2017/5/5.
 */

public interface DownloadListener {
    void onProgress(int progress);

    void onSuccess();

    void onFailed();

    void onPaused();

    void onCanceled();
}
