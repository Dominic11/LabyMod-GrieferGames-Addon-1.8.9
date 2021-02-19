package de.wuzlwuz.griefergames.settings;

import java.awt.*;
import java.util.List;

import com.google.gson.JsonObject;

import de.wuzlwuz.griefergames.GrieferGames;
import de.wuzlwuz.griefergames.enums.EnumLanguages;
import de.wuzlwuz.griefergames.enums.EnumRealnameShown;
import de.wuzlwuz.griefergames.enums.EnumSounds;
import net.labymod.gui.elements.ColorPicker;
import net.labymod.gui.elements.DropDownMenu;
import net.labymod.main.LabyMod;
import net.labymod.main.lang.LanguageManager;
import net.labymod.settings.elements.*;
import net.labymod.utils.Consumer;
import net.labymod.utils.Material;
import org.apache.commons.codec.language.bm.Lang;

public class ModSettings {
	public static final String DEFAULT_AMP_REPLACEMENT_CHAT = "[AMP] %CLEAN%",
			DEFAULT_AMP_REPLACEMENT_TABLIST = "[AMP] %CLEAN%",
			DEFAULT_AFK_NICKNAME = "AFK_%name%";

	private TextElement infoText;

	private boolean modEnabled = true;

	private EnumLanguages language = EnumLanguages.GAMELANGUAGE;

	private String overrideRank = null;

	private boolean showChatTime = false;
	private boolean chatTimeShortFormat = true;
	private boolean chatTimeAfterMessage = false;

	private boolean privateChatRight = true;
	private boolean plotChatRight = true;
	private EnumSounds privateChatSound = EnumSounds.NONE;
	private EnumRealnameShown realname = EnumRealnameShown.DEFAULT;
	// private boolean realnameClick = false;
	private boolean msgDisplayNameClick = true;
	private boolean filterDuplicateMessages = false;
	private Integer filterDuplicateMessagesTime = 5;

	private boolean cleanBlanks = false;
	private boolean cleanSupremeBlanks = false;

	private boolean highlightMentions = true;
	private Color mentionsColor = new Color(121, 178, 255);

	private boolean afkNick = false;
	private String afkNickname = DEFAULT_AFK_NICKNAME;
	private int afkTime = 15;
	private boolean afkMsgAnswear = false;
	private String afkMsgText = "Ich bin momentan AFK ;)";

	private boolean payChatRight = true;
	private boolean payAchievement = false;
	private boolean payMarker = false;
	private boolean payHover = false;

	private boolean bankChatRight = true;
	private boolean bankAchievement = false;

	private boolean itemRemoverChatRight = false;
	private boolean itemRemoverLastTimeHover = true;

	private boolean mobRemoverChatRight = false;
	private boolean mobRemoverLastTimeHover = true;

	private boolean betterIgnoreList = true;

	private boolean ampEnabled = true;
	private boolean ampClanEnabled = false;
	private String ampChatReplacement = DEFAULT_AMP_REPLACEMENT_CHAT;
	private String ampTablistReplacement = DEFAULT_AMP_REPLACEMENT_TABLIST;

	private boolean preventCommandFailure = false;

	private boolean markTPAMsg = true;

	private boolean cleanVoteMsg = false;

	private boolean cleanNewsMsg = false;

	private boolean updateBoosterState = true;

	private boolean clearMapCache = false;

	private boolean labyChatShowSubServerEnabled = true;
	private boolean discordShowSubServerEnabled = true;

	private boolean autoPortal = false;

	private boolean hideBoosterMenu = true;

	private boolean autoUpdate = true;
	private boolean vanishOnJoin = false;
	private boolean flyOnJoin = false;


	private GrieferGames getGG() {
		return GrieferGames.getGriefergames();
	}

	private JsonObject getConfig() {
		return getGG().getConfig();
	}
	private void saveConfig() {
		getGG().saveConfig();
	}

	public boolean isModEnabled() {
		return this.modEnabled;
	}

	public EnumLanguages getLanguage() {
		return language;
	}

	public String getOverrideRank() {
		return overrideRank;
	}

	public boolean isShowChatTime() {
		return this.showChatTime;
	}

	public boolean isChatTimeAfterMessage() {
		return chatTimeAfterMessage;
	}

	public boolean isChatTimeShortFormat() {
		return chatTimeShortFormat;
	}

	public boolean isPrivateChatRight() {
		return this.privateChatRight;
	}

	public boolean isPlotChatRight() {
		return this.plotChatRight;
	}

	public EnumSounds getPrivateChatSound() {
		return this.privateChatSound;
	}

	public boolean isPrivateChatSound() {
		return (getPrivateChatSoundPath().length() > 0);
	}

	public String getPrivateChatSoundPath() {
		switch (this.privateChatSound) {
		case BASS:
			return "note.bass";
		case BASSDRUM:
			return "note.bd";
		case HARP:
			return "note.harp";
		case HAT:
			return "note.hat";
		case PLING:
			return "note.pling";
		case POP:
			return "random.pop";
		case SNARE:
			return "note.snare";
		default:
			return "";
		}
	}

	public EnumRealnameShown getRealname() {
		return this.realname;
	}

	public boolean isRealnameRight() {
		return (this.realname.equals(EnumRealnameShown.SECONDCHAT) || this.realname.equals(EnumRealnameShown.BOTH));
	}

	public boolean isRealnameBoth() {
		return this.realname.equals(EnumRealnameShown.BOTH);
	}

	/*
	 * private void setRealnameClick(boolean realnameClick) { this.realnameClick =
	 * realnameClick; }
	 * 
	 * public boolean isRealnameClick() { return this.realnameClick; }
	 */

	public boolean isMsgDisplayNameClick() {
		return this.msgDisplayNameClick;
	}

	public boolean isPreventCommandFailure() {
		return this.preventCommandFailure;
	}

	public boolean isFilterDuplicateMessages() {
		return this.filterDuplicateMessages;
	}

	public Integer getFilterDuplicateMessagesTime() {
		return filterDuplicateMessagesTime;
	}

	public boolean isCleanBlanks() {
		return this.cleanBlanks;
	}

	public boolean isCleanSupremeBlanks() {
		return this.cleanSupremeBlanks;
	}

	public boolean isHighlightMentions() {
		return highlightMentions;
	}

	public Color getMentionsColor() {
		return mentionsColor;
	}

	public boolean isPayChatRight() {
		return this.payChatRight;
	}

	public boolean isPayAchievement() {
		return this.payAchievement;
	}

	public boolean isPayMarker() {
		return this.payMarker;
	}

	public boolean isPayHover() {
		return this.payHover;
	}

	public boolean isAfkNick() {
		return afkNick;
	}

	public boolean isAfkMsgAnswear() {
		return afkMsgAnswear;
	}

	public String getAfkMsgText() {
		return afkMsgText;
	}

	public String getAfkNickname() {
		return afkNickname;
	}

	public int getAfkTime() {
		return afkTime;
	}

	public boolean isBankChatRight() {
		return this.bankChatRight;
	}

	public boolean isBankAchievement() {
		return this.bankAchievement;
	}

	public boolean isItemRemoverChatRight() {
		return this.itemRemoverChatRight;
	}

	public boolean isItemRemoverLastTimeHover() {
		return this.itemRemoverLastTimeHover;
	}

	public boolean isMobRemoverChatRight() {
		return this.mobRemoverChatRight;
	}

	public boolean isMobRemoverLastTimeHover() {
		return this.mobRemoverLastTimeHover;
	}

	public boolean isBetterIgnoreList() {
		return this.betterIgnoreList;
	}

	public boolean isAMPEnabled() {
		return this.ampEnabled;
	}

	public boolean isAMPClanEnabled() {
		return this.ampClanEnabled;
	}

	public String getAMPChatReplacement() {
		return ampChatReplacement;
	}

	public String getAMPTablistReplacement() {
		return ampTablistReplacement;
	}

	public boolean isMarkTPAMsg() {
		return markTPAMsg;
	}

	public boolean isCleanVoteMsg() {
		return cleanVoteMsg;
	}

	public boolean isCleanNewsMsg() {
		return cleanNewsMsg;
	}

	public boolean isUpdateBoosterState() {
		return updateBoosterState;
	}

	public boolean isClearMapCache() {
		return clearMapCache;
	}

	public boolean isLabyChatShowSubServerEnabled() {
		return labyChatShowSubServerEnabled;
	}

	public boolean isDiscordShowSubServerEnabled() {
		return discordShowSubServerEnabled;
	}

	public boolean isAutoPortl() {
		return autoPortal;
	}

	public boolean isHideBoosterMenu() {
		return hideBoosterMenu;
	}

	public boolean isAutoUpdate() {
		return autoUpdate;
	}

	public boolean isVanishOnJoin() {
		return vanishOnJoin;
	}

	public boolean isFlyOnJoin() {
		return flyOnJoin;
	}

	public void loadConfig() {
		if (getConfig().has("modEnabled"))
			modEnabled = getConfig().get("modEnabled").getAsBoolean();

		if (getConfig().has("language")) {
			for (EnumLanguages enumLanguage : EnumLanguages.values()) {
				if (enumLanguage.name().equalsIgnoreCase(getConfig().get("language").getAsString())) {
					language = enumLanguage;
				}
			}
		}

		if(getConfig().has("overrideRank"))
			overrideRank = getConfig().get("overrideRank").getAsString();

		if (getConfig().has("showChatTime"))
			showChatTime = getConfig().get("showChatTime").getAsBoolean();

		if (getConfig().has("chatTimeAfterMessage"))
			chatTimeAfterMessage = getConfig().get("chatTimeAfterMessage").getAsBoolean();

		if (getConfig().has("chatTimeShortFormat"))
			chatTimeShortFormat = getConfig().get("chatTimeShortFormat").getAsBoolean();

		if (getConfig().has("privateChatRight"))
			privateChatRight = getConfig().get("privateChatRight").getAsBoolean();

		if (getConfig().has("privateChatSound")) {
			for (EnumSounds sound : EnumSounds.values()) {
				if (sound.name().equalsIgnoreCase(getConfig().get("privateChatSound").getAsString())) {
					privateChatSound = sound;
				}
			}
		}

		if (getConfig().has("msgDisplayNameClick"))
			msgDisplayNameClick = getConfig().get("msgDisplayNameClick").getAsBoolean();

		if (getConfig().has("filterDuplicateMessages"))
			filterDuplicateMessages = getConfig().get("filterDuplicateMessages").getAsBoolean();

		if (getConfig().has("filterDuplicateMessagesTime"))
			 filterDuplicateMessagesTime = getConfig().get("filterDuplicateMessagesTime").getAsInt();

		if (getConfig().has("cleanBlanks"))
			cleanBlanks = getConfig().get("cleanBlanks").getAsBoolean();

		if (getConfig().has("cleanSupremeBlanks"))
			cleanSupremeBlanks = getConfig().get("cleanSupremeBlanks").getAsBoolean();

		if(getConfig().has("highlightMentions"))
			highlightMentions = getConfig().get("highlightMentions").getAsBoolean();

		if(getConfig().has("mentionsColor"))
			mentionsColor = new Color(getConfig().get("mentionsColor").getAsInt());

		if (getConfig().has("payChatRight"))
			payChatRight = getConfig().get("payChatRight").getAsBoolean();

		if (getConfig().has("payAchievement"))
			payAchievement = getConfig().get("payAchievement").getAsBoolean();

		if (getConfig().has("payMarker"))
			payMarker = getConfig().get("payMarker").getAsBoolean();

		if (getConfig().has("payHover"))
			payHover = getConfig().get("payHover").getAsBoolean();

		if(getConfig().has("afkNick"))
			afkNick = getConfig().get("afkNick").getAsBoolean();

		if(getConfig().has("afkMsgAnswear"))
			afkMsgAnswear = getConfig().get("afkMsgAnswear").getAsBoolean();

		if(getConfig().has("afkMsgText"))
			afkMsgText = getConfig().get("afkMsgText").getAsString();

		if(getConfig().has("afkNickname"))
			afkNickname = getConfig().get("afkNickname").getAsString();

		if(getConfig().has("afkTime"))
			afkTime = getConfig().get("afkTime").getAsInt();

		if (getConfig().has("bankChatRight"))
			bankChatRight = getConfig().get("bankChatRight").getAsBoolean();

		if (getConfig().has("bankAchievement"))
			bankAchievement = getConfig().get("bankAchievement").getAsBoolean();

		if (getConfig().has("plotChatRight"))
			plotChatRight = getConfig().get("plotChatRight").getAsBoolean();

		if (getConfig().has("realname")) {
			for (EnumRealnameShown enumRealname : EnumRealnameShown.values()) {
				if (enumRealname.name().equalsIgnoreCase(getConfig().get("realname").getAsString())) {
					realname = enumRealname;
				}
			}
		}

		/*
		 * if (getConfig().has("realnameClick"))
		 * setRealnameClick(getConfig().get("realnameClick").getAsBoolean());
		 */

		if (getConfig().has("itemRemoverChatRight"))
			itemRemoverChatRight = getConfig().get("itemRemoverChatRight").getAsBoolean();

		if (getConfig().has("itemRemoverLastTimeHover"))
			itemRemoverLastTimeHover = getConfig().get("itemRemoverLastTimeHover").getAsBoolean();

		if (getConfig().has("mobRemoverChatRight"))
			mobRemoverChatRight = getConfig().get("mobRemoverChatRight").getAsBoolean();

		if (getConfig().has("mobRemoverLastTimeHover"))
			mobRemoverLastTimeHover = getConfig().get("mobRemoverLastTimeHover").getAsBoolean();

		if (getConfig().has("betterIgnoreList"))
			betterIgnoreList = getConfig().get("betterIgnoreList").getAsBoolean();

		if (getConfig().has("ampEnabled"))
			ampEnabled = getConfig().get("ampEnabled").getAsBoolean();

		if (getConfig().has("ampClanEnabled"))
			ampClanEnabled = getConfig().get("ampClanEnabled").getAsBoolean();

		if (getConfig().has("chatReplacement"))
			ampChatReplacement = getConfig().get("chatReplacement").getAsString();

		if (getConfig().has("tablistReplacement"))
			ampTablistReplacement = getConfig().get("tablistReplacement").getAsString();

		if (getConfig().has("preventCommandFailure"))
			preventCommandFailure = getConfig().get("preventCommandFailure").getAsBoolean();

		if (getConfig().has("markTPAMsg"))
			markTPAMsg = getConfig().get("markTPAMsg").getAsBoolean();

		if (getConfig().has("cleanVoteMsg"))
			cleanVoteMsg = getConfig().get("cleanVoteMsg").getAsBoolean();

		if (getConfig().has("cleanNewsMsg"))
			cleanNewsMsg = getConfig().get("cleanNewsMsg").getAsBoolean();

		if (getConfig().has("updateBoosterState"))
			updateBoosterState = getConfig().get("updateBoosterState").getAsBoolean();

		if (getConfig().has("clearMapCache"))
			clearMapCache = getConfig().get("clearMapCache").getAsBoolean();

		if (getConfig().has("labyChatShowSubServerEnabled"))
			labyChatShowSubServerEnabled = getConfig().get("labyChatShowSubServerEnabled").getAsBoolean();
		if (getConfig().has("discordShowSubServerEnabled"))
			discordShowSubServerEnabled = getConfig().get("discordShowSubServerEnabled").getAsBoolean();

		if (getConfig().has("autoPortal"))
			autoPortal = getConfig().get("autoPortal").getAsBoolean();

		if (getConfig().has("hideBoosterMenu"))
			hideBoosterMenu = getConfig().get("hideBoosterMenu").getAsBoolean();

		if (getConfig().has("autoUpdate"))
			autoUpdate = getConfig().get("autoUpdate").getAsBoolean();

		if (getConfig().has("vanishOnJoin"))
			vanishOnJoin = getConfig().get("vanishOnJoin").getAsBoolean();

		if (getConfig().has("flyOnJoin"))
			flyOnJoin = getConfig().get("flyOnJoin").getAsBoolean();
	}

	public void fillSettings(final List<SettingsElement> settings) {
		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_general")));

		final BooleanElement modEnabledBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_addonEnabled"),
				new ControlElement.IconData(Material.LEVER), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						modEnabled = value;
						getConfig().addProperty("modEnabled", value);
						saveConfig();
					}
				}, modEnabled);
		settings.add(modEnabledBtn);

		final BooleanElement autoUpdateBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_autoUpdate"),
				new ControlElement.IconData("labymod/textures/settings/settings/serverlistliveview.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				autoUpdate = value;
				getConfig().addProperty("autoUpdate", value);
				saveConfig();
				updateInfo();
			}
		}, autoUpdate);
		settings.add(autoUpdateBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_language")));
		final DropDownMenu<EnumLanguages> languageDropDownMenu = new DropDownMenu<EnumLanguages>(
				LanguageManager.translateOrReturnKey("settings_gg_addonLanguage"), 0, 0, 0, 0).fill(EnumLanguages.values());

		final DropDownElement<EnumLanguages> languageDropDown = new DropDownElement<EnumLanguages>(
				LanguageManager.translateOrReturnKey("settings_gg_addonLanguage"), languageDropDownMenu);

		languageDropDownMenu.setSelected(language);

		languageDropDown.setChangeListener(new Consumer<EnumLanguages>() {
			@Override
			public void accept(EnumLanguages value) {
				language = value;
				getConfig().addProperty("language", value.name());
				saveConfig();
			}
		});
		settings.add(languageDropDown);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_messages")));

		final BooleanElement privateChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_privateChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						privateChatRight = value;
						getConfig().addProperty("privateChatRight", value);
						saveConfig();
					}
				}, privateChatRight);
		settings.add(privateChatRightBtn);

		final DropDownMenu<EnumSounds> privateChatSoundDropDownMenu = new DropDownMenu<EnumSounds>(
				LanguageManager.translateOrReturnKey("settings_gg_privateMessageSound"), 0, 0, 0, 0).fill(EnumSounds.values());

		final DropDownElement<EnumSounds> privateChatSoundDropDown = new DropDownElement<EnumSounds>(
				LanguageManager.translateOrReturnKey("settings_gg_privateMessageSound"), privateChatSoundDropDownMenu);

		// Set selected entry
		privateChatSoundDropDownMenu.setSelected(privateChatSound);

		// Listen on changes
		privateChatSoundDropDown.setChangeListener(new Consumer<EnumSounds>() {
			@Override
			public void accept(EnumSounds value) {
				privateChatSound = value;
				getConfig().addProperty("privateChatSound", value.name());
				saveConfig();
			}
		});
		settings.add(privateChatSoundDropDown);

		final BooleanElement plotChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_plotChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						plotChatRight = value;
						getConfig().addProperty("plotChatRight", value);
						saveConfig();
					}
				}, plotChatRight);
		settings.add(plotChatRightBtn);

		final BooleanElement msgDisplayNameClickBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_clickToAnswer"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatshortcuts.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						msgDisplayNameClick = value;
						getConfig().addProperty("msgDisplayNameClick", value);
						saveConfig();
					}
				}, msgDisplayNameClick);
		settings.add(msgDisplayNameClickBtn);

		final BooleanElement filterDuplicateMessagesBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_filterDuplicateMessages"),
				new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						filterDuplicateMessages = value;
						getConfig().addProperty("filterDuplicateMessages", filterDuplicateMessages);
						saveConfig();
					}
				}, filterDuplicateMessages);
		settings.add(filterDuplicateMessagesBtn);

		final NumberElement filterDuplicateMessagesTimeNumber = new NumberElement(LanguageManager.translateOrReturnKey("settings_gg_filterDuplicateMessagesTime"),
				new ControlElement.IconData(Material.WATCH),
				filterDuplicateMessagesTime);
		filterDuplicateMessagesTimeNumber.setMinValue(3);
		filterDuplicateMessagesTimeNumber.setMaxValue(60);
		filterDuplicateMessagesTimeNumber.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer value) {
				filterDuplicateMessagesTime = value;
				getConfig().addProperty("filterDuplicateMessagesTime", value);
				saveConfig();
			}
		});
		settings.add(filterDuplicateMessagesTimeNumber);

		final BooleanElement preventCommandFailureBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_blockIncorrectCommands"),
				new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						preventCommandFailure = value;
						getConfig().addProperty("preventCommandFailure", value);
						saveConfig();
					}
				}, preventCommandFailure);
		settings.add(preventCommandFailureBtn);

		final BooleanElement markTPAMsgBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_highlightTpaMessages"),
				new ControlElement.IconData("labymod/textures/settings/settings/second_chat.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						markTPAMsg = value;
						getConfig().addProperty("markTPAMsg", value);
						saveConfig();
					}
				}, markTPAMsg);
		settings.add(markTPAMsgBtn);

		final BooleanElement cleanVoteMsgBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_deleteVoteMessages"),
				new ControlElement.IconData(Material.BARRIER),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						cleanVoteMsg = value;
						getConfig().addProperty("cleanVoteMsg", value);
						saveConfig();
					}
				}, cleanVoteMsg);
		settings.add(cleanVoteMsgBtn);

		final BooleanElement cleanNewsMsgBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_deleteNewsMessages"),
				new ControlElement.IconData(Material.BARRIER),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						cleanNewsMsg = value;
						getConfig().addProperty("cleanNewsMsg", value);
						saveConfig();
					}
				}, cleanNewsMsg);
		settings.add(cleanNewsMsgBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_chattime")));
		final BooleanElement showChatTimeBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_displayChatTime"),
				new ControlElement.IconData(Material.WATCH), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				showChatTime = value;
				getConfig().addProperty("showChatTime", value);
				saveConfig();
			}
		}, showChatTime);
		settings.add(showChatTimeBtn);

		final BooleanElement chatTimeShortFormatBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_chatTimeShortVersion"),
				new ControlElement.IconData(Material.WATCH), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				chatTimeShortFormat = value;
				getConfig().addProperty("chatTimeShortFormat", value);
				saveConfig();
			}
		}, chatTimeShortFormat);
		settings.add(chatTimeShortFormatBtn);

		final BooleanElement chatTimeAfterMessageBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_chatTimeAfterMessage"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				chatTimeAfterMessage = value;
				getConfig().addProperty("chatTimeAfterMessage", value);
				saveConfig();
			}
		}, chatTimeAfterMessage);
		settings.add(chatTimeAfterMessageBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_realname")));
		final DropDownMenu<EnumRealnameShown> realnameDropDownMenu = new DropDownMenu<EnumRealnameShown>(
				LanguageManager.translateOrReturnKey("settings_gg_showRealname"), 0, 0, 0, 0).fill(EnumRealnameShown.values());

		final DropDownElement<EnumRealnameShown> realnameDropDown = new DropDownElement<EnumRealnameShown>(
				LanguageManager.translateOrReturnKey("settings_gg_showRealname"), realnameDropDownMenu);

		// Set selected entry
		realnameDropDownMenu.setSelected(realname);

		// Listen on changes
		realnameDropDown.setChangeListener(new Consumer<EnumRealnameShown>() {
			@Override
			public void accept(EnumRealnameShown value) {
				realname = value;
				getConfig().addProperty("realname", value.name());
				saveConfig();
			}
		});
		settings.add(realnameDropDown);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_blankLines")));
		final BooleanElement cleanBlanksBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_cleanBlanks"),
				new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						cleanBlanks = value;
						getConfig().addProperty("cleanBlanks", value);
						saveConfig();
					}
				}, cleanBlanks);
		settings.add(cleanBlanksBtn);

		final BooleanElement cleanSupremeBlanksBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_cleanSupremeBlanks"),
				new ControlElement.IconData(Material.BARRIER), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						cleanSupremeBlanks = value;
						getConfig().addProperty("cleanSupremeBlanks", value);
						saveConfig();
					}
				}, cleanSupremeBlanks);
		settings.add(cleanSupremeBlanksBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_mentions")));
		final BooleanElement highlightMentionsBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_highlightMentions"),
			new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
			new Consumer<Boolean>() {
				@Override
				public void accept(Boolean value) {
					highlightMentions = value;
					getConfig().addProperty("highlightMentions", value);
					saveConfig();
				}
			}, highlightMentions);
		settings.add(highlightMentionsBtn);

		final ColorPickerCheckBoxBulkElement mentionsColorBulkElement = new ColorPickerCheckBoxBulkElement("");
		final ColorPicker mentionsColorPicker = new ColorPicker(LanguageManager.translateOrReturnKey("settings_gg_mentionColor"), mentionsColor, null, 0, 0, 0, 0);
		mentionsColorPicker.setHasAdvanced(true);
		mentionsColorPicker.setUpdateListener(new Consumer<Color>() {
			@Override
			public void accept(Color value) {
				mentionsColor = value;
				getConfig().addProperty("mentionsColor", value.getRGB());
				saveConfig();
			}
		});
		mentionsColorBulkElement.addColorPicker(mentionsColorPicker);
		settings.add(mentionsColorBulkElement);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_afk")));
		final NumberElement afkTimeSetting = new NumberElement(LanguageManager.translateOrReturnKey("settings_gg_afkTime"),
				new ControlElement.IconData(Material.WATCH),
				afkTime);
		afkTimeSetting.setMinValue(1);
		afkTimeSetting.setMaxValue(60);
		afkTimeSetting.addCallback(new Consumer<Integer>() {
			@Override
			public void accept(Integer value) {
				afkTime = value;
				getConfig().addProperty("afkTime", value);
				saveConfig();
			}
		});
		settings.add(afkTimeSetting);

		final BooleanElement afkNickBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_afkNick"),
				new ControlElement.IconData("labymod/textures/settings/modules/afk_timer.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						afkNick = value;
						getConfig().addProperty("afkNick", value);
						saveConfig();
					}
				}, afkNick);
		settings.add(afkNickBtn);

		final StringElement afkNicknameSetting = new StringElement(LanguageManager.translateOrReturnKey("settings_gg_afkNickname"),
				new ControlElement.IconData(Material.BOOK_AND_QUILL), afkNickname, new Consumer<String>() {
			@Override
			public void accept(String value) {
				afkNickname = value;
				getConfig().addProperty("afkNickname", value);
				saveConfig();
			}
		});
		settings.add(afkNicknameSetting);

		final BooleanElement afkMsgAnswearBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_afkMsgAnswear"),
				new ControlElement.IconData("labymod/textures/settings/modules/afk_timer.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						afkMsgAnswear = value;
						getConfig().addProperty("afkMsgAnswear", value);
						saveConfig();
					}
				}, afkMsgAnswear);
		settings.add(afkMsgAnswearBtn);

		final StringElement afkMsgTextSetting = new StringElement(LanguageManager.translateOrReturnKey("settings_gg_afkMsgText"),
				new ControlElement.IconData(Material.BOOK_AND_QUILL), afkMsgText, new Consumer<String>() {
			@Override
			public void accept(String value) {
				afkMsgText = value;
				getConfig().addProperty("afkMsgText", value);
				saveConfig();
			}
		});
		settings.add(afkMsgTextSetting);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_payment")));
		final BooleanElement payChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_payChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						payChatRight = value;
						getConfig().addProperty("payChatRight", value);
						saveConfig();
					}
				}, payChatRight);
		settings.add(payChatRightBtn);

		final BooleanElement payAchievementBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_payAchievement"),
				new ControlElement.IconData(Material.BOOK), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						payAchievement = value;
						getConfig().addProperty("payAchievement", value);
						saveConfig();
					}
				}, payAchievement);
		settings.add(payAchievementBtn);

		final BooleanElement payMarkerBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_payHighlight"),
				new ControlElement.IconData("labymod/textures/settings/settings/second_chat.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						payMarker = value;
						getConfig().addProperty("payMarker", value);
						saveConfig();
					}
				}, payMarker);
		settings.add(payMarkerBtn);

		final BooleanElement payHoverBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_payHover"),
				new ControlElement.IconData("labymod/textures/settings/settings/bettershaderselection.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						payHover = value;
						getConfig().addProperty("payHover", value);
						saveConfig();
					}
				}, payHover);
		settings.add(payHoverBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_bank")));
		final BooleanElement bankChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_bankChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						bankChatRight = value;
						getConfig().addProperty("bankChatRight", value);
						saveConfig();
					}
				}, bankChatRight);
		settings.add(bankChatRightBtn);

		final BooleanElement bankAchievementBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_bankAchievement"),
				new ControlElement.IconData(Material.BOOK), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						bankAchievement = value;
						getConfig().addProperty("bankAchievement", value);
						saveConfig();
					}
				}, bankAchievement);
		settings.add(bankAchievementBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_clearlag")));
		final BooleanElement itemRemoverChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_clearlagChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						itemRemoverChatRight = value;
						getConfig().addProperty("itemRemoverChatRight", value);
						saveConfig();
					}
				}, itemRemoverChatRight);
		settings.add(itemRemoverChatRightBtn);

		final BooleanElement itemRemoverLastTimeHoverBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_clearlagTimeHover"),
				new ControlElement.IconData(Material.WATCH), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						itemRemoverLastTimeHover = value;
						getConfig().addProperty("itemRemoverLastTimeHover", value);
						saveConfig();
					}
				}, itemRemoverLastTimeHover);
		settings.add(itemRemoverLastTimeHoverBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_mobremover")));
		final BooleanElement mobRemoverChatRightBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_mobRemoverChatRight"),
				new ControlElement.IconData("labymod/textures/settings/settings/chatpositionright.png"),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						mobRemoverChatRight = value;
						getConfig().addProperty("mobRemoverChatRight", value);
						saveConfig();
					}
				}, mobRemoverChatRight);
		settings.add(mobRemoverChatRightBtn);

		final BooleanElement mobRemoverLastTimeHoverBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_mobRemoverTimeHover"),
				new ControlElement.IconData(Material.WATCH), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						mobRemoverChatRight = value;
						getConfig().addProperty("mobRemoverLastTimeHover", value);
						saveConfig();
					}
				}, mobRemoverChatRight);
		settings.add(mobRemoverLastTimeHoverBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_ignoredPlayers")));
		final BooleanElement betterIgnoreListBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_betterIgnoreList"),
				new ControlElement.IconData("labymod/textures/settings/settings/publicserverlist.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						betterIgnoreList = value;
						getConfig().addProperty("betterIgnoreList", value);
						saveConfig();
					}
				}, betterIgnoreList);
		settings.add(betterIgnoreListBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_maps")));
		final BooleanElement clearMapCacheBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_clearMapCache"),
				new ControlElement.IconData(Material.EMPTY_MAP),
				new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						clearMapCache = value;
						getConfig().addProperty("clearMapCache", clearMapCache);
						saveConfig();
					}
				}, clearMapCache);
		settings.add(clearMapCacheBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_updateboosterstatus")));
		final BooleanElement updateBoosterStateBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_updateBoosterStatusEnabled"),
				new ControlElement.IconData("labymod/textures/settings/settings/serverlistliveview.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						updateBoosterState = value;
						getConfig().addProperty("updateBoosterState", value);
						saveConfig();
					}
				}, updateBoosterState);
		settings.add(updateBoosterStateBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_antimagicprefix")));
		final BooleanElement ampEnabledBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_antiMagicPrefixEnabled"),
				new ControlElement.IconData("labymod/textures/settings/settings/particlefix.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						ampEnabled = value;
						getConfig().addProperty("ampEnabled", value);
						saveConfig();
					}
				}, ampEnabled);
		settings.add(ampEnabledBtn);

		final StringElement chatReplacementInput = new StringElement(LanguageManager.translateOrReturnKey("settings_gg_antiMagicPrefixChatReplacement"),
				new ControlElement.IconData(Material.BOOK_AND_QUILL), ampChatReplacement, new Consumer<String>() {
					@Override
					public void accept(String value) {
						ampChatReplacement = value;
						getConfig().addProperty("chatReplacement", value);
						saveConfig();
					}
				});
		settings.add(chatReplacementInput);

		final StringElement tablistReplacementInput = new StringElement(LanguageManager.translateOrReturnKey("settings_gg_antiMagicPrefixTablistReplacement"),
				new ControlElement.IconData(Material.BOOK_AND_QUILL), ampTablistReplacement, new Consumer<String>() {
					@Override
					public void accept(String value) {
						ampTablistReplacement = value;
						getConfig().addProperty("tablistReplacement", value);
						saveConfig();
					}
				});
		settings.add(tablistReplacementInput);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_antimagicclantag")));
		final BooleanElement ampClanEnabledBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_antiMagicClanTagEnabled"),
				new ControlElement.IconData("labymod/textures/settings/settings/particlefix.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						ampClanEnabled = value;
						getConfig().addProperty("ampClanEnabled", value);
						saveConfig();
					}
				}, ampClanEnabled);
		settings.add(ampClanEnabledBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_labychat")));
		final BooleanElement labyChatShowSubServerEnabledBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_labyChatEnabled"),
				new ControlElement.IconData("labymod/textures/settings/settings/motd.png"), new Consumer<Boolean>() {
					@Override
					public void accept(Boolean value) {
						labyChatShowSubServerEnabled = value;
						getConfig().addProperty("labyChatShowSubServerEnabled", value);
						saveConfig();
						if(value) {
							getGG().getHelper().updateLabyChatSubServer("lobby");
						} else {
							getGG().getHelper().updateLabyChatSubServer("reset");
						}
					}
				}, labyChatShowSubServerEnabled);
		settings.add(labyChatShowSubServerEnabledBtn);

		final BooleanElement discordShowSubServerEnabledBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_discordEnabled"),
				new ControlElement.IconData("labymod/textures/settings/settings/discordrichpresence.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				discordShowSubServerEnabled = value;
				getConfig().addProperty("discordShowSubServerEnabled", value);
				saveConfig();
				if(value) {
					getGG().getHelper().updateDiscordSubServer("lobby");
				} else {
					getGG().getHelper().updateDiscordSubServer("reset");
				}
			}
		}, discordShowSubServerEnabled);
		settings.add(discordShowSubServerEnabledBtn);

		settings.add(new HeaderElement(LanguageManager.translateOrReturnKey("settings_gg_heads_automatisations")));
		final BooleanElement autoPortalBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_portalOnJoin"),
				new ControlElement.IconData("labymod/textures/chat/autotext.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				autoPortal = value;
				getConfig().addProperty("autoPortal", value);
				saveConfig();
			}
		}, autoPortal);
		settings.add(autoPortalBtn);

		final BooleanElement hodeBoosterMenuBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_hideBoosterMenu"),
				new ControlElement.IconData("labymod/textures/chat/autotext.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				hideBoosterMenu = value;
				getConfig().addProperty("hideBoosterMenu", value);
				saveConfig();
			}
		}, hideBoosterMenu);
		settings.add(hodeBoosterMenuBtn);

		final BooleanElement vanishOnJoinBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_vanishOnJoin"),
				new ControlElement.IconData("labymod/textures/chat/autotext.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				vanishOnJoin = value;
				getConfig().addProperty("vanishOnJoin", value);
				saveConfig();
			}
		}, vanishOnJoin);
		settings.add(vanishOnJoinBtn);

		final BooleanElement flyOnJoinBtn = new BooleanElement(LanguageManager.translateOrReturnKey("settings_gg_flyOnJoin"),
				new ControlElement.IconData("labymod/textures/chat/autotext.png"), new Consumer<Boolean>() {
			@Override
			public void accept(Boolean value) {
				flyOnJoin = value;
				getConfig().addProperty("flyOnJoin", value);
				saveConfig();
			}
		}, flyOnJoin);
		settings.add(flyOnJoinBtn);

		infoText = new TextElement("");
		updateInfo();
		settings.add(infoText);
	}

	private void updateInfo() {
		String text = "§7Version: §e"+GrieferGames.VERSION;
		if(getGG().getUpdater().isUpdateAvailable()) {
			text += " §c(";
			if(autoUpdate) {
				if(getGG().getUpdater().canDoUpdate()) {
					text += LanguageManager.translateOrReturnKey("message_gg_updateReady");
				} else {
					text += LanguageManager.translateOrReturnKey("message_gg_updateFailed");
				}
			} else {
				text += LanguageManager.translateOrReturnKey("message_gg_updateAvailable");
			}
			text += ")";
		}

		text += "\n§7GitHub: §bhttps://github.com/Neocraftr/LabyMod-GrieferGames-Addon-1.8.9";
		infoText.setText(text);
	}
}