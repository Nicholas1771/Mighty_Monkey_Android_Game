package com.applovin.impl.sdk;

import com.applovin.impl.p003a.C0196q;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/* renamed from: com.applovin.impl.sdk.dn */
class C0387dn {

    /* renamed from: A */
    public static final C0389dp<Long> f766A = m829a("ad_refresh_seconds", 120L);

    /* renamed from: B */
    public static final C0389dp<Boolean> f767B = m829a("mrec_ad_refresh_enabled", true);

    /* renamed from: C */
    public static final C0389dp<Long> f768C = m829a("mrec_ad_refresh_seconds", 120L);

    /* renamed from: D */
    public static final C0389dp<Boolean> f769D = m829a("leader_ad_refresh_enabled", true);

    /* renamed from: E */
    public static final C0389dp<Long> f770E = m829a("leader_ad_refresh_seconds", 120L);

    /* renamed from: F */
    public static final C0389dp<String> f771F = m829a("plugin_version", "");

    /* renamed from: G */
    public static final C0389dp<Boolean> f772G = m829a("ad_preload_enabled", true);

    /* renamed from: H */
    public static final C0389dp<Boolean> f773H = m829a("ad_resource_caching_enabled", true);

    /* renamed from: I */
    public static final C0389dp<Boolean> f774I = m829a("fail_ad_load_on_failed_video_cache", true);

    /* renamed from: J */
    public static final C0389dp<String> f775J = m829a("resource_cache_prefix", "https://vid.applovin.com/,https://pdn.applovin.com/,https://img.applovin.com/,https://d.applovin.com/,https://assets.applovin.com/,https://cdnjs.cloudflare.com/,http://vid.applovin.com/,http://pdn.applovin.com/,http://img.applovin.com/,http://d.applovin.com/,http://assets.applovin.com/,http://cdnjs.cloudflare.com/");

    /* renamed from: K */
    public static final C0389dp<String> f776K = m829a("ad_auto_preload_sizes", "INTER,BANNER,MREC");

    /* renamed from: L */
    public static final C0389dp<String> f777L = m829a("ad_auto_preload_msizes", "INTER");

    /* renamed from: M */
    public static final C0389dp<Boolean> f778M = m829a("ad_auto_preload_incent", true);

    /* renamed from: N */
    public static final C0389dp<Boolean> f779N = m829a("ad_auto_preload_mincent", true);

    /* renamed from: O */
    public static final C0389dp<Boolean> f780O = m829a("is_track_ad_info", true);

    /* renamed from: P */
    public static final C0389dp<Boolean> f781P = m829a("force_back_button_enabled_always", false);

    /* renamed from: Q */
    public static final C0389dp<Integer> f782Q = m829a("close_fade_in_time", 400);

    /* renamed from: R */
    public static final C0389dp<Boolean> f783R = m829a("show_close_on_exit", true);

    /* renamed from: S */
    public static final C0389dp<String> f784S = m829a("text_incent_prompt_title", "Earn a Reward");

    /* renamed from: T */
    public static final C0389dp<String> f785T = m829a("text_incent_prompt_body", "Would you like to watch a video for a reward?");

    /* renamed from: U */
    public static final C0389dp<String> f786U = m829a("text_incent_prompt_yes_option", "Watch Now");

    /* renamed from: V */
    public static final C0389dp<String> f787V = m829a("text_incent_prompt_no_option", "No Thanks");

    /* renamed from: W */
    public static final C0389dp<String> f788W = m829a("text_incent_completion_title", "Video Reward");

    /* renamed from: X */
    public static final C0389dp<String> f789X = m829a("text_incent_completion_body_success", "You have earned a reward!");

    /* renamed from: Y */
    public static final C0389dp<String> f790Y = m829a("text_incent_completion_body_quota_exceeded", "You have already earned the maximum reward for today.");

    /* renamed from: Z */
    public static final C0389dp<String> f791Z = m829a("text_incent_completion_body_reward_rejected", "Your reward was rejected.");

    /* renamed from: a */
    public static final C0389dp<Boolean> f792a = m829a("is_disabled", false);

    /* renamed from: aA */
    public static final C0389dp<Integer> f793aA = m829a("extended_preload_capacity_mrec", 15);

    /* renamed from: aB */
    public static final C0389dp<Integer> f794aB = m829a("extended_preload_capacity_mmrec", 15);

    /* renamed from: aC */
    public static final C0389dp<Integer> f795aC = m829a("extended_preload_capacity_inter", 15);

    /* renamed from: aD */
    public static final C0389dp<Integer> f796aD = m829a("extended_preload_capacity_minter", 15);

    /* renamed from: aE */
    public static final C0389dp<Integer> f797aE = m829a("extended_preload_capacity_leader", 15);

    /* renamed from: aF */
    public static final C0389dp<Integer> f798aF = m829a("extended_preload_capacity_mleader", 15);

    /* renamed from: aG */
    public static final C0389dp<Integer> f799aG = m829a("extended_preload_capacity_incent", 15);

    /* renamed from: aH */
    public static final C0389dp<Integer> f800aH = m829a("extended_preload_capacity_mincent", 15);

    /* renamed from: aI */
    public static final C0389dp<Boolean> f801aI = m829a("dismiss_video_on_error", true);

    /* renamed from: aJ */
    public static final C0389dp<String> f802aJ = m829a("precache_delimiters", ")]',");

    /* renamed from: aK */
    public static final C0389dp<Integer> f803aK = m829a("close_button_size_video", 30);

    /* renamed from: aL */
    public static final C0389dp<Integer> f804aL = m829a("close_button_top_margin_video", 8);

    /* renamed from: aM */
    public static final C0389dp<Integer> f805aM = m829a("close_button_right_margin_video", 4);

    /* renamed from: aN */
    public static final C0389dp<Boolean> f806aN = m829a("force_back_button_enabled_poststitial", false);

    /* renamed from: aO */
    public static final C0389dp<Boolean> f807aO = m829a("force_back_button_enabled_close_button", false);

    /* renamed from: aP */
    public static final C0389dp<Integer> f808aP = m829a("close_button_touch_area", 0);

    /* renamed from: aQ */
    public static final C0389dp<Boolean> f809aQ = m829a("is_video_skippable", false);

    /* renamed from: aR */
    public static final C0389dp<Boolean> f810aR = m829a("cache_cleanup_enabled", false);

    /* renamed from: aS */
    public static final C0389dp<Long> f811aS = m829a("cache_file_ttl_seconds", 86400L);

    /* renamed from: aT */
    public static final C0389dp<Integer> f812aT = m829a("cache_max_size_mb", -1);

    /* renamed from: aU */
    public static final C0389dp<Boolean> f813aU = m829a("preload_merge_init_tasks_incent", true);

    /* renamed from: aV */
    public static final C0389dp<Boolean> f814aV = m829a("preload_merge_init_tasks_inter", true);

    /* renamed from: aW */
    public static final C0389dp<Boolean> f815aW = m829a("preload_merge_init_tasks_banner", true);

    /* renamed from: aX */
    public static final C0389dp<Boolean> f816aX = m829a("preload_merge_init_tasks_mrec", true);

    /* renamed from: aY */
    public static final C0389dp<Boolean> f817aY = m829a("preload_merge_init_tasks_leader", true);

    /* renamed from: aZ */
    public static final C0389dp<Boolean> f818aZ = m829a("preload_merge_init_tasks_mincent", true);

    /* renamed from: aa */
    public static final C0389dp<String> f819aa = m829a("text_incent_completion_body_network_failure", "We were unable to contact the rewards server. Please try again later.");

    /* renamed from: ab */
    public static final C0389dp<String> f820ab = m829a("text_incent_completion_close_option", "Okay");

    /* renamed from: ac */
    public static final C0389dp<Boolean> f821ac = m829a("incent_warning_enabled", false);

    /* renamed from: ad */
    public static final C0389dp<String> f822ad = m829a("text_incent_warning_title", "Attention!");

    /* renamed from: ae */
    public static final C0389dp<String> f823ae = m829a("text_incent_warning_body", "You won’t get your reward if the video hasn’t finished.");

    /* renamed from: af */
    public static final C0389dp<String> f824af = m829a("text_incent_warning_close_option", "Close");

    /* renamed from: ag */
    public static final C0389dp<String> f825ag = m829a("text_incent_warning_continue_option", "Keep Watching");

    /* renamed from: ah */
    public static final C0389dp<Boolean> f826ah = m829a("incent_nonvideo_warning_enabled", false);

    /* renamed from: ai */
    public static final C0389dp<String> f827ai = m829a("text_incent_nonvideo_warning_title", "Attention!");

    /* renamed from: aj */
    public static final C0389dp<String> f828aj = m829a("text_incent_nonvideo_warning_body", "You won’t get your reward if the game hasn’t finished.");

    /* renamed from: ak */
    public static final C0389dp<String> f829ak = m829a("text_incent_nonvideo_warning_close_option", "Close");

    /* renamed from: al */
    public static final C0389dp<String> f830al = m829a("text_incent_nonvideo_warning_continue_option", "Keep Playing");

    /* renamed from: am */
    public static final C0389dp<Boolean> f831am = m829a("show_incent_prepopup", true);

    /* renamed from: an */
    public static final C0389dp<Boolean> f832an = m829a("show_incent_postpopup", true);

    /* renamed from: ao */
    public static final C0389dp<Integer> f833ao = m829a("preload_capacity_banner", 1);

    /* renamed from: ap */
    public static final C0389dp<Integer> f834ap = m829a("preload_capacity_mbanner", 1);

    /* renamed from: aq */
    public static final C0389dp<Integer> f835aq = m829a("preload_capacity_mrec", 1);

    /* renamed from: ar */
    public static final C0389dp<Integer> f836ar = m829a("preload_capacity_mmrec", 1);

    /* renamed from: as */
    public static final C0389dp<Integer> f837as = m829a("preload_capacity_inter", 1);

    /* renamed from: at */
    public static final C0389dp<Integer> f838at = m829a("preload_capacity_minter", 1);

    /* renamed from: au */
    public static final C0389dp<Integer> f839au = m829a("preload_capacity_leader", 1);

    /* renamed from: av */
    public static final C0389dp<Integer> f840av = m829a("preload_capacity_mleader", 1);

    /* renamed from: aw */
    public static final C0389dp<Integer> f841aw = m829a("preload_capacity_incent", 2);

    /* renamed from: ax */
    public static final C0389dp<Integer> f842ax = m829a("preload_capacity_mincent", 2);

    /* renamed from: ay */
    public static final C0389dp<Integer> f843ay = m829a("extended_preload_capacity_banner", 15);

    /* renamed from: az */
    public static final C0389dp<Integer> f844az = m829a("extended_preload_capacity_mbanner", 15);

    /* renamed from: b */
    public static final C0389dp<Boolean> f845b = m829a("honor_publisher_settings", true);

    /* renamed from: bA */
    public static final C0389dp<Integer> f846bA = m829a("mute_button_margin", 10);

    /* renamed from: bB */
    public static final C0389dp<Integer> f847bB = m829a("mute_button_gravity", 85);

    /* renamed from: bC */
    public static final C0389dp<Boolean> f848bC = m829a("qq", false);

    /* renamed from: bD */
    public static final C0389dp<Boolean> f849bD = m829a("hw_accelerate_webviews", false);

    /* renamed from: bE */
    public static final C0389dp<Boolean> f850bE = m829a("mute_videos", false);

    /* renamed from: bF */
    public static final C0389dp<Boolean> f851bF = m829a("show_mute_by_default", false);

    /* renamed from: bG */
    public static final C0389dp<Boolean> f852bG = m829a("mute_with_user_settings", true);

    /* renamed from: bH */
    public static final C0389dp<String> f853bH = m829a("top_level_events", "landing,checkout,iap");

    /* renamed from: bI */
    public static final C0389dp<Boolean> f854bI = m829a("events_enabled", true);

    /* renamed from: bJ */
    public static final C0389dp<Boolean> f855bJ = m829a("force_ssl", false);

    /* renamed from: bK */
    public static final C0389dp<Integer> f856bK = m829a("postback_service_max_queue_size", 100);

    /* renamed from: bL */
    public static final C0389dp<Integer> f857bL = m829a("max_postback_attempts", 3);

    /* renamed from: bM */
    public static final C0389dp<Boolean> f858bM = m829a("click_overlay_enabled", false);

    /* renamed from: bN */
    public static final C0389dp<String> f859bN = m829a("click_overlay_color", "#66000000");

    /* renamed from: bO */
    public static final C0389dp<Integer> f860bO = m829a("click_tracking_retry_count_v1", 3);

    /* renamed from: bP */
    public static final C0389dp<Integer> f861bP = m829a("click_tracking_retry_delay", 2000);

    /* renamed from: bQ */
    public static final C0389dp<Integer> f862bQ = m829a("click_tracking_timeout", 10000);

    /* renamed from: bR */
    public static final C0389dp<Integer> f863bR = m829a("android_click_spinner_size", 50);

    /* renamed from: bS */
    public static final C0389dp<Integer> f864bS = m829a("android_click_spinner_style", 16973853);

    /* renamed from: bT */
    public static final C0389dp<Boolean> f865bT = m829a("android_require_external_storage_permission", true);

    /* renamed from: bU */
    public static final C0389dp<Boolean> f866bU = m829a("android_drop_nomedia", true);

    /* renamed from: bV */
    public static final C0389dp<Boolean> f867bV = m829a("native_auto_cache_preload_resources", true);

    /* renamed from: bW */
    public static final C0389dp<Boolean> f868bW = m829a("video_immersive_mode_enabled", false);

    /* renamed from: bX */
    public static final C0389dp<Boolean> f869bX = m829a("sanitize_webview", false);

    /* renamed from: bY */
    public static final C0389dp<Boolean> f870bY = m829a("force_rerender", false);

    /* renamed from: bZ */
    public static final C0389dp<String> f871bZ = m829a("webview_package_name", "com.google.android.webview");

    /* renamed from: ba */
    public static final C0389dp<Boolean> f872ba = m829a("preload_merge_init_tasks_minter", true);

    /* renamed from: bb */
    public static final C0389dp<Boolean> f873bb = m829a("preload_merge_init_tasks_mbanner", true);

    /* renamed from: bc */
    public static final C0389dp<Boolean> f874bc = m829a("preload_merge_init_tasks_mmrec", true);

    /* renamed from: bd */
    public static final C0389dp<Boolean> f875bd = m829a("preload_merge_init_tasks_mleader", true);

    /* renamed from: be */
    public static final C0389dp<Integer> f876be = m829a("submit_postback_timeout", 10000);

    /* renamed from: bf */
    public static final C0389dp<Integer> f877bf = m829a("submit_postback_retries", 4);

    /* renamed from: bg */
    public static final C0389dp<Integer> f878bg = m829a("widget_imp_tracking_delay", 2000);

    /* renamed from: bh */
    public static final C0389dp<Boolean> f879bh = m829a("draw_countdown_clock", true);

    /* renamed from: bi */
    public static final C0389dp<Integer> f880bi = m829a("countdown_clock_size", 32);

    /* renamed from: bj */
    public static final C0389dp<Integer> f881bj = m829a("countdown_clock_stroke_size", 4);

    /* renamed from: bk */
    public static final C0389dp<Integer> f882bk = m829a("countdown_clock_text_size", 28);

    /* renamed from: bl */
    public static final C0389dp<Boolean> f883bl = m829a("ad_auto_preload_native", true);

    /* renamed from: bm */
    public static final C0389dp<Boolean> f884bm = m829a("widget_fail_on_slot_count_diff", true);

    /* renamed from: bn */
    public static final C0389dp<Boolean> f885bn = m829a("video_zero_length_as_computed", false);

    /* renamed from: bo */
    public static final C0389dp<Integer> f886bo = m829a("video_countdown_clock_margin", 10);

    /* renamed from: bp */
    public static final C0389dp<Integer> f887bp = m829a("video_countdown_clock_gravity", 83);

    /* renamed from: bq */
    public static final C0389dp<Integer> f888bq = m829a("preload_capacity_widget", 1);

    /* renamed from: br */
    public static final C0389dp<Integer> f889br = m829a("widget_latch_timeout_ms", 500);

    /* renamed from: bs */
    public static final C0389dp<Boolean> f890bs = m829a("android_gc_on_widget_detach", true);

    /* renamed from: bt */
    public static final C0389dp<Boolean> f891bt = m829a("lhs_close_button_video", false);

    /* renamed from: bu */
    public static final C0389dp<Boolean> f892bu = m829a("lhs_skip_button", true);

    /* renamed from: bv */
    public static final C0389dp<Boolean> f893bv = m829a("countdown_toggleable", false);

    /* renamed from: bw */
    public static final C0389dp<Integer> f894bw = m829a("native_batch_precache_count", 1);

    /* renamed from: bx */
    public static final C0389dp<Boolean> f895bx = m829a("mute_controls_enabled", false);

    /* renamed from: by */
    public static final C0389dp<Boolean> f896by = m829a("allow_user_muting", true);

    /* renamed from: bz */
    public static final C0389dp<Integer> f897bz = m829a("mute_button_size", 32);

    /* renamed from: c */
    public static final C0389dp<String> f898c = m829a("device_id", "");

    /* renamed from: cA */
    public static final C0389dp<Long> f899cA = m829a("progress_bar_step", 25L);

    /* renamed from: cB */
    public static final C0389dp<Integer> f900cB = m829a("progress_bar_scale", 10000);

    /* renamed from: cC */
    public static final C0389dp<Integer> f901cC = m829a("progress_bar_vertical_padding", -8);

    /* renamed from: cD */
    public static final C0389dp<Boolean> f902cD = m829a("empty_imp", true);

    /* renamed from: cE */
    public static final C0389dp<Boolean> f903cE = m829a("click_failed_expand", false);

    /* renamed from: cF */
    public static final C0389dp<Boolean> f904cF = m829a("ignore_is_showing", false);

    /* renamed from: cG */
    public static final C0389dp<String> f905cG = m829a("wrapped_sizes", "");

    /* renamed from: cH */
    public static final C0389dp<Boolean> f906cH = m829a("return_wrapped_ad_on_empty_queue", false);

    /* renamed from: cI */
    public static final C0389dp<Boolean> f907cI = m829a("cleanup_webview", false);

    /* renamed from: cJ */
    public static final C0389dp<Boolean> f908cJ = m829a("dismiss_expanded_adview_on_refresh", false);

    /* renamed from: cK */
    public static final C0389dp<Boolean> f909cK = m829a("dismiss_expanded_adview_on_detach", false);

    /* renamed from: cL */
    public static final C0389dp<Boolean> f910cL = m829a("detach_update_listener_on_pause", false);

    /* renamed from: cM */
    public static final C0389dp<Boolean> f911cM = m829a("contract_on_close_ad_command", false);

    /* renamed from: cN */
    public static final C0389dp<Integer> f912cN = m829a("response_buffer_size", 16000);

    /* renamed from: cO */
    public static final C0389dp<Boolean> f913cO = m829a("sp_apply", true);

    /* renamed from: cP */
    public static final C0389dp<Integer> f914cP = m829a("vast_max_wrapper_depth", 5);

    /* renamed from: cQ */
    public static final C0389dp<Integer> f915cQ = m829a("vast_wrapper_resolution_retry_count_v1", 1);

    /* renamed from: cR */
    public static final C0389dp<Integer> f916cR = m829a("vast_wrapper_resolution_connection_timeout", 30000);

    /* renamed from: cS */
    public static final C0389dp<Integer> f917cS = m829a("vast_max_response_length", 640000);

    /* renamed from: cT */
    public static final C0389dp<Integer> f918cT = m829a("vast_video_selection_policy", Integer.valueOf(C0196q.MEDIUM.ordinal()));

    /* renamed from: cU */
    public static final C0389dp<String> f919cU = m829a("vast_image_html", "<html><head><style>html,body{height:100%;width:100%}body{background-image:url({SOURCE});background-repeat:no-repeat;background-size:contain;background-position:center;}a{position:absolute;top:0;bottom:0;left:0;right:0}</style></head><body><a href=\"applovin://com.applovin.sdk/adservice/track_click_now\"></a></body></html>");

    /* renamed from: cV */
    public static final C0389dp<String> f920cV = m829a("vast_link_html", "<html><head><style>html,body,iframe{height:100%;width:100%;}body{margin:0}iframe{border:0;overflow:hidden;position:absolute}</style></head><body><iframe src={SOURCE} frameborder=0></iframe></body></html>");

    /* renamed from: cW */
    public static final C0389dp<Long> f921cW = m829a("vast_progress_tracking_countdown_step", 1000L);

    /* renamed from: cX */
    public static final C0389dp<String> f922cX = m829a("vast_unsupported_video_types", "video/ogg,video/x-flv");

    /* renamed from: cY */
    public static final C0389dp<String> f923cY = m829a("vast_unsupported_video_extensions", "ogv,flv");

    /* renamed from: cZ */
    public static final C0389dp<Boolean> f924cZ = m829a("vast_validate_with_extension_if_no_video_type", true);

    /* renamed from: ca */
    public static final C0389dp<Boolean> f925ca = m829a("check_webview_has_gesture", false);

    /* renamed from: cb */
    public static final C0389dp<Boolean> f926cb = m829a("adr", false);

    /* renamed from: cc */
    public static final C0389dp<Boolean> f927cc = m829a("hgn", false);

    /* renamed from: cd */
    public static final C0389dp<String> f928cd = m829a("emulator_hardware_list", "ranchu,goldfish,vbox");

    /* renamed from: ce */
    public static final C0389dp<String> f929ce = m829a("emulator_device_list", "generic,vbox");

    /* renamed from: cf */
    public static final C0389dp<String> f930cf = m829a("emulator_manufacturer_list", "Genymotion");

    /* renamed from: cg */
    public static final C0389dp<String> f931cg = m829a("emulator_model_list", "Android SDK built for x86");

    /* renamed from: ch */
    public static final C0389dp<Long> f932ch = m829a("inter_display_delay", 200L);

    /* renamed from: ci */
    public static final C0389dp<Float> f933ci = m829a("volume_normalization_factor", Float.valueOf(6.6666665f));

    /* renamed from: cj */
    public static final C0389dp<Boolean> f934cj = m829a("lock_specific_orientation", false);

    /* renamed from: ck */
    public static final C0389dp<Boolean> f935ck = m829a("video_callbacks_for_incent_nonvideo_ads_enabled", true);

    /* renamed from: cl */
    public static final C0389dp<Boolean> f936cl = m829a("user_agent_collection_enabled", false);

    /* renamed from: cm */
    public static final C0389dp<Long> f937cm = m829a("user_agent_collection_timeout_ms", 600L);

    /* renamed from: cn */
    public static final C0389dp<Boolean> f938cn = m829a("handle_window_actions", false);

    /* renamed from: co */
    public static final C0389dp<String> f939co = m829a("soft_buttons_resource_id", "config_showNavigationBar");

    /* renamed from: cp */
    public static final C0389dp<Boolean> f940cp = m829a("immediate_render", false);

    /* renamed from: cq */
    public static final C0389dp<Long> f941cq = m829a("video_resume_delay", 250L);

    /* renamed from: cr */
    public static final C0389dp<Long> f942cr = m829a("force_hide_status_bar_delay_ms", 0L);

    /* renamed from: cs */
    public static final C0389dp<Boolean> f943cs = m829a("load_ads_if_no_internet", true);

    /* renamed from: ct */
    public static final C0389dp<Boolean> f944ct = m829a("display_ads_if_no_internet", true);

    /* renamed from: cu */
    public static final C0389dp<Long> f945cu = m829a("expandable_close_button_animation_duration_ms", 300L);

    /* renamed from: cv */
    public static final C0389dp<Integer> f946cv = m829a("expandable_close_button_size", 27);

    /* renamed from: cw */
    public static final C0389dp<Integer> f947cw = m829a("expandable_h_close_button_margin", 10);

    /* renamed from: cx */
    public static final C0389dp<Integer> f948cx = m829a("expandable_t_close_button_margin", 10);

    /* renamed from: cy */
    public static final C0389dp<Boolean> f949cy = m829a("expandable_lhs_close_button", false);

    /* renamed from: cz */
    public static final C0389dp<Integer> f950cz = m829a("expandable_close_button_touch_area", 0);

    /* renamed from: d */
    public static final C0389dp<String> f951d = m829a("publisher_id", "");

    /* renamed from: da */
    public static final C0389dp<Integer> f952da = m829a("num_ads_preload_ahead", 2);

    /* renamed from: db */
    public static final C0389dp<Boolean> f953db = m829a("mediation_load_last_session_adapters_on_next_init", true);

    /* renamed from: dc */
    public static final C0389dp<Boolean> f954dc = m829a("mediation_load_predefined_adapters_on_next_init", true);

    /* renamed from: dd */
    public static final C0389dp<Boolean> f955dd = m829a("mediation_track_imp", true);

    /* renamed from: de */
    public static final C0389dp<Boolean> f956de = m829a("mediation_track_clk", true);

    /* renamed from: df */
    public static final C0389dp<Boolean> f957df = m829a("mediation_track_err", true);

    /* renamed from: dg */
    private static final List<?> f958dg = Arrays.asList(new Class[]{Boolean.class, Float.class, Integer.class, Long.class, String.class});

    /* renamed from: dh */
    private static final List<C0389dp<?>> f959dh = new ArrayList();

    /* renamed from: e */
    public static final C0389dp<String> f960e = m829a("device_token", "");

    /* renamed from: f */
    public static final C0389dp<Integer> f961f = m829a("submit_data_retry_count_v1", 1);

    /* renamed from: g */
    public static final C0389dp<Integer> f962g = m829a("vr_retry_count_v1", 1);

    /* renamed from: h */
    public static final C0389dp<Integer> f963h = m829a("fetch_ad_retry_count_v1", 1);

    /* renamed from: i */
    public static final C0389dp<Boolean> f964i = m829a("is_verbose_logging", false);

    /* renamed from: j */
    public static final C0389dp<String> f965j = m829a("api_endpoint", "https://d.applovin.com/");

    /* renamed from: k */
    public static final C0389dp<String> f966k = m829a("adserver_endpoint", "https://a.applovin.com/");

    /* renamed from: l */
    public static final C0389dp<String> f967l = m829a("mediation_tracking_endpoint", "https://rt.applovin.com/med");

    /* renamed from: m */
    public static final C0389dp<String> f968m = m829a("event_tracking_endpoint", "https://rt.applovin.com/pix");

    /* renamed from: n */
    public static final C0389dp<String> f969n = m829a("api_backup_endpoint", "https://d.applvn.com/");

    /* renamed from: o */
    public static final C0389dp<String> f970o = m829a("adserver_backup_endpoint", "https://a.applvn.com/");

    /* renamed from: p */
    public static final C0389dp<String> f971p = m829a("event_tracking_backup_endpoint", "https://rt.applvn.com/pix");

    /* renamed from: q */
    public static final C0389dp<Long> f972q = m829a("get_retry_delay_v1", 10000L);

    /* renamed from: r */
    public static final C0389dp<String> f973r = m829a("hash_algorithm", "SHA-1");

    /* renamed from: s */
    public static final C0389dp<Integer> f974s = m829a("short_hash_size", 16);

    /* renamed from: t */
    public static final C0389dp<Integer> f975t = m829a("http_connection_timeout", 30000);

    /* renamed from: u */
    public static final C0389dp<Integer> f976u = m829a("fetch_ad_connection_timeout", 30000);

    /* renamed from: v */
    public static final C0389dp<Integer> f977v = m829a("http_socket_timeout", 20000);

    /* renamed from: w */
    public static final C0389dp<Integer> f978w = m829a("ad_session_minutes", 60);

    /* renamed from: x */
    public static final C0389dp<String> f979x = m829a("sc", "");

    /* renamed from: y */
    public static final C0389dp<String> f980y = m829a("ad_request_parameters", "");

    /* renamed from: z */
    public static final C0389dp<Boolean> f981z = m829a("ad_refresh_enabled", true);

    /* renamed from: a */
    private static <T> C0389dp<T> m829a(String str, T t) {
        if (t == null) {
            throw new IllegalArgumentException("No default value specified");
        } else if (!f958dg.contains(t.getClass())) {
            throw new IllegalArgumentException("Unsupported value type: " + t.getClass());
        } else {
            C0389dp<T> dpVar = new C0389dp<>(str, t);
            f959dh.add(dpVar);
            return dpVar;
        }
    }

    /* renamed from: a */
    public static Collection<C0389dp<?>> m830a() {
        return Collections.unmodifiableList(f959dh);
    }

    /* renamed from: b */
    public static int m831b() {
        return f959dh.size();
    }
}
