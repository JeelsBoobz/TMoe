package cc.ioctl.tmoe.hook.func

import cc.ioctl.tmoe.base.annotation.FunctionHookEntry
import cc.ioctl.tmoe.hook.base.CommonDynamicHook
import com.github.kyuubiran.ezxhelper.utils.findAllMethods
import com.github.kyuubiran.ezxhelper.utils.findMethod
import com.github.kyuubiran.ezxhelper.utils.hookBefore
import com.github.kyuubiran.ezxhelper.utils.tryOrFalse

@FunctionHookEntry
object AntiSecretMedia : CommonDynamicHook() {
    override fun initOnce(): Boolean = tryOrFalse {
        findAllMethods("org.telegram.messenger.MessageObject") { name == "isSecretMedia" }.hookBefore {
            if (isEnabled) it.result = false
        }
    }
}