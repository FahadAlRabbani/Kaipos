package me.fahadalrabbani.kaipos;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Bundle;

/**
 * Created by achernar on 21/08/15.
 */
public class AlertDialogFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Context context = getActivity();
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(R.string.dialog_title_error);
        builder.setMessage(R.string.dialog_message_error);
        builder.setPositiveButton(R.string.dialog_ok_button, null);
        AlertDialog dialog = builder.create();
        return dialog;
    }
}
