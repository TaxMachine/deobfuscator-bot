package dev.maxtachine.utils.webhook.objects;

public class DiscordWebhook {
    private String applicationId;
    private String avatar;
    private String channelId;
    private String guildId;
    private String id;
    private String name;
    private int type;
    private User user;
    private String token;
    private String url;

    public String getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(String applicationId) {
        this.applicationId = applicationId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getGuildId() {
        return guildId;
    }

    public void setGuildId(String guildId) {
        this.guildId = guildId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public static class User {
        private String id;
        private String username;
        private String avatar;
        private String discriminator;
        private int publicFlags;
        private int flags;
        private String banner;
        private int accentColor;
        private String globalName;
        private String avatarDecorationData;
        private String bannerColor;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getDiscriminator() {
            return discriminator;
        }

        public void setDiscriminator(String discriminator) {
            this.discriminator = discriminator;
        }

        public int getPublicFlags() {
            return publicFlags;
        }

        public void setPublicFlags(int publicFlags) {
            this.publicFlags = publicFlags;
        }

        public int getFlags() {
            return flags;
        }

        public void setFlags(int flags) {
            this.flags = flags;
        }

        public String getBanner() {
            return banner;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public int getAccentColor() {
            return accentColor;
        }

        public void setAccentColor(int accentColor) {
            this.accentColor = accentColor;
        }

        public String getGlobalName() {
            return globalName;
        }

        public void setGlobalName(String globalName) {
            this.globalName = globalName;
        }

        public String getAvatarDecorationData() {
            return avatarDecorationData;
        }

        public void setAvatarDecorationData(String avatarDecorationData) {
            this.avatarDecorationData = avatarDecorationData;
        }

        public String getBannerColor() {
            return bannerColor;
        }

        public void setBannerColor(String bannerColor) {
            this.bannerColor = bannerColor;
        }
    }
}
