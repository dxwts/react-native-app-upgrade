package com.songlcy.rnupgrade;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;

class UpdateDialog {

//     static void show(final Context context, String content, final String downloadUrl) {
//         if (isContextValid(context)) {
//             AlertDialog.Builder builder = new AlertDialog.Builder(context);
//             builder.setTitle(R.string.android_auto_update_dialog_title);
//             builder.setMessage(Html.fromHtml(content))
//                     .setPositiveButton(R.string.android_auto_update_dialog_btn_download, new DialogInterface.OnClickListener() {
//                         public void onClick(DialogInterface dialog, int id) {
//                             goToDownload(context, downloadUrl);
//                         }
//                     })
//                     .setNegativeButton(R.string.android_auto_update_dialog_btn_cancel, new DialogInterface.OnClickListener() {
//                         public void onClick(DialogInterface dialog, int id) {
//                         }
//                     });

//             AlertDialog dialog = builder.create();
//             //点击对话框外面,对话框不消失
//             dialog.setCanceledOnTouchOutside(false);
//             dialog.show();
//         }
//     }

    static Intent intentDownloadService;

    private static boolean isContextValid(Context context) {
        return context instanceof Activity && !((Activity) context).isFinishing();
    }

    public static void goToDownload(Context context, String downloadUrl) {
        intentDownloadService = new Intent(context.getApplicationContext(), DownloadService.class);
        intentDownloadService.putExtra(Constants.APK_DOWNLOAD_URL, downloadUrl);
        context.startService(intentDownloadService);
    }

    public static void cancelDownload(Context context) {
        if(intentDownloadService != null) {
            context.stopService(intentDownloadService);
            intentDownloadService = null;
        }
    }
    
}
