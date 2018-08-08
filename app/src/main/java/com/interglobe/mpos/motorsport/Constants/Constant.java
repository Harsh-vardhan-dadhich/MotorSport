package com.interglobe.mpos.motorsport.Constants;

/**
 * Created by arms0071 on 8/7/18.
 */

public interface Constant {



    String kAppPreferences = "MotorSportInPreferences";
    String kEmptyString = "";
    Number kEmptyNumber = 0;
    String kMessage = "message";
    String kStatus = "status";
    String kMessageInternalInconsistency = "Some internal inconsistency occurred. Please try again.";
    String kMessageServerNotRespondingError = "PeepsIn server not responding!";
    String kSocketTimeOut = "PeepsIn Server not responding..";
    String kDefaultAppName = "MotorSport";












    /*****************************Public Static Constant and Keys**********************************/

    /**
     * Message direction Enum
     */
    enum MessageDirection {
        send(2),
        receive(1);


        private int value;

        MessageDirection(int value) {
            this.value = value;
        }

        /**
         * Convert int to MessageDirection
         */
        public static MessageDirection getMessageDirection(int value) {
            for (MessageDirection direction : MessageDirection.values()) {
                if (direction.value == value) {
                    return direction;
                }
            }
            return send;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum MessageStatus {
        error(0),              /* an error occured */
        sending(1),          /*sending message is in progress*/
        send(2),            /* message has been sent to server  */
        sent(3),            /* message has been arrived at receivers end */
        uploadedToSever(4);         /*Image uploaded to server*/

        private int value;

        MessageStatus(int value) {
            this.value = value;
        }

        /**
         * Convert int to MessageStatus
         */
        public static MessageStatus getMessageStatus(int value) {
            for (MessageStatus status : MessageStatus.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            return sending;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum ConversationStatus {
        publicStatus(0),
        privateStatus(1),
        noNotificationStatus(2);

        private int value;

        ConversationStatus(int value) {
            this.value = value;
        }

        /**
         * Convert int to ConversationStatus
         */
        public static ConversationStatus getConversationStatus(int value) {
            for (ConversationStatus status : ConversationStatus.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            return publicStatus;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    /**
     * Http Status for API Response
     */
    enum HTTPStatus {
        success(200),
        badRequest(400),
        unauthorized(401),
        notFound(404),
        methodNotAllowed(405),
        notAcceptable(406),
        proxyAuthenticationRequired(407),
        requestTimeout(408),
        error(-100);         //No option found.

        //Defination
        private int httpStatus;

        HTTPStatus(int httpStatus) {
            this.httpStatus = httpStatus;
        }

        public static HTTPStatus getStatus(int status) {
            for (HTTPStatus httpStatus : HTTPStatus.values()) {
                if (httpStatus.httpStatus == status) {
                    return httpStatus;
                }
            }
            return error;
        }

        public Integer getValue() {
            return this.httpStatus;
        }
    }

    /**
     * Status Enumration for Task Status
     */
    enum Status {
        success(0),
        fail(1),
        reachLimit(2),
        noChange(3),
        history(4),            //If xmpp message is history
        normal(5),            //If Normal xmpp message
        discard(6);

        //Defination
        private int value;

        Status(int status) {
            this.value = status;
        }

        public static Status getStatus(int value) {
            for (Status status : Status.values()) {
                if (status.value == value) {
                    return status;
                }
            }
            return fail;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    /**
     * This enum is used for message type
     */
    enum MessageType {
        text(0),
        image(1),
        audio(2),
        video(3),
        file(4),                //image file, video file, audio file
        history(5),
        none(6);

        private int value;

        MessageType(int value) {
            this.value = value;
        }

        /**
         * Convert int to Gender Type
         */
        public static MessageType getMessageType(int value) {
            for (MessageType messageType : MessageType.values()) {
                if (messageType.value == value) {
                    return messageType;
                }
            }
            return none;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    /**
     * enum For MediaType
     */
    enum MediaType {
        image(1),
        audio(2),
        video(3),
        file(4);

        private int value;

        MediaType(int value) {
            this.value = value;
        }

        /**
         * Convert int to Media Type
         */
        public static MediaType getMediaType(int value) {
            for (MediaType mediaType : MediaType.values()) {
                if (mediaType.value == value) {
                    return mediaType;
                }
            }
            return image;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum Gender {
        male(1),
        female(2),
        other(3);
        //Defination
        private int value;

        Gender(int gender) {
            this.value = gender;
        }

        /**
         * Convert int to Gender Type
         */
        public static Gender getGender(int value) {
            for (Gender gender : Gender.values()) {
                if (gender.value == value) {
                    return gender;
                }
            }
            return male;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum UserRegType {
        system(1),
        facebook(2),
        google(3),
        twitter(4);

        private int value;

        UserRegType(int regType) {
            this.value = regType;
        }

        /**
         * Convert int to UserRegType Type
         */
        public static UserRegType getRegType(int value) {
            for (UserRegType regType : UserRegType.values()) {
                if (regType.value == value) {
                    return regType;
                }
            }
            return system;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum ContactType {
        system(1),
        facebook(2),
        google(3),
        twitter(4),
        phone(5);

        private int value;

        ContactType(int contactType) {
            this.value = contactType;
        }

        /**
         * Convert int to DeviceType Type
         */
        public static ContactType getContactType(int value) {
            for (ContactType contactType : ContactType.values()) {
                if (contactType.value == value) {
                    return contactType;
                }
            }
            return system;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum DeviceType {
        iOS(1),
        android(2);

        private int value;

        DeviceType(int deviceType) {
            this.value = deviceType;
        }

        /**
         * Convert int to DeviceType Type
         */
        public static DeviceType getDeviceType(int value) {
            for (DeviceType deviceType : DeviceType.values()) {
                if (deviceType.value == value) {
                    return deviceType;
                }
            }
            return android;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum GroupType {
        publicGroup(1),
        privateGroup(2);

        private int value;

        GroupType(int groupType) {
            this.value = groupType;
        }

        /**
         * Convert int to GroupType Type
         */
        public static GroupType getGroupType(int value) {
            for (GroupType groupType : GroupType.values()) {
                if (groupType.value == value) {
                    return groupType;
                }
            }
            return publicGroup;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }
    }

    enum NotificationType {
        groupInvitationReceived(1),
        groupRequestApproved(2),
        groupRequestRejected(3),
        groupSubscriptionCancelled(4),
        friendRequestReceived(5),
        friendRequestAccepted(6),
        connectionRemoved(7);

        private int value;

        NotificationType(int i) {
            this.value = i;
        }


    }

    enum GeoAddressType {
        premise(1),
        street_number(2),
        route(3),
        locality(4),
        administrative_area_level_2(5),
        administrative_area_level_1(6),
        country(7),
        postal_code(8);

        private int value;

        GeoAddressType(int deviceType) {
            this.value = deviceType;
        }

        /**
         * Convert int to DeviceType Type
         */
        public static GeoAddressType geoAddressType(int value) {
            for (GeoAddressType geoAddressType : GeoAddressType.values()) {
                if (geoAddressType.value == value) {
                    return geoAddressType;
                }
            }
            return premise;
        }

        /**
         * To get Integer value of corresponding emum
         */
        public Integer getValue() {
            return this.value;
        }

    }









}
