package io.lbry.browser.ui.verification;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.google.android.material.button.MaterialButton;

import io.lbry.browser.R;
import io.lbry.browser.listener.SignInListener;
import io.lbry.browser.utils.Helper;
import lombok.Setter;

public class ManualVerificationFragment extends Fragment {
    @Setter
    private SignInListener listener;

    private static final double SKIP_QUEUE_PRICE = 4.99;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_verification_manual, container, false);

        Context context = getContext();
        MaterialButton buttonSkipQueue = root.findViewById(R.id.verification_manual_skip_queue);
        buttonSkipQueue.setText(context.getString(R.string.skip_queue_button_text, String.valueOf(SKIP_QUEUE_PRICE)));

        Helper.applyHtmlForTextView(root.findViewById(R.id.verification_manual_discord_verify));
        root.findViewById(R.id.verification_manual_continue_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listener != null) {
                    listener.onManualVerifyContinue();
                }
            }
        });

        return root;
    }
}
