package com.spring.boot.coffeine.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.*;
import java.math.BigDecimal;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {

    private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";


    public static boolean isEmpty(Object object) {
        return object == null ? true : (object instanceof String && ((String) object).trim().isEmpty());
    }

    public static boolean isNumeric(String str) {
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    public static boolean telnet(String ip, int port) {
        Socket socket = null;
        InputStream inputStream = null;
        try {
            socket = new Socket();
            socket.connect(new InetSocketAddress(ip, port), 2000);
            inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            return true;
        } catch (Exception e) {
            return false;
        } finally {
            Utils.close(inputStream);
            Utils.close(socket);
        }
    }

    public static void close(Statement statement) {
        try {
            if (statement != null) {
                statement.close();
            }
        } catch (SQLException ex) {
            // NOOP
        }
    }

    public static void close(Closeable closeable) {
        try {
            if (closeable != null) {
                closeable.close();
            }
        } catch (Exception ex) {
            // NOOP
        }
    }

    public static void close(ResultSet resultSet) {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException ex) {
            // NOOP
        }
    }

    public static void close(Connection connection) {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException ex) {
            // NOOP
        }
    }

    public static String nullToEmpty(Object object) {
        return object == null ? "" : object.toString();
    }

    public static Number emptyToZero(Object object) {
        return isEmpty(object) ? 0 : new BigDecimal(object.toString());
    }

    public static String exceptionToString(Throwable ex) {
        StringWriter errors = new StringWriter();
        ex.printStackTrace(new PrintWriter(errors));
        return errors.toString();
    }

    public static String showNumber(Object number) {
        if (isEmpty(number)) {
            number = 0;
        }
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(number).replaceAll(",", ".");
    }

    public static String showNumberFromString(String number) {
        int num = Integer.parseInt(number);
        DecimalFormat formatter = new DecimalFormat("#,###");
        return formatter.format(num).replaceAll(",", ".");
    }

    public static boolean isExistFromConfig(String strProperties, String element) {
        if (Utils.isEmpty(strProperties)) {
            return false;
        }
        String[] arr = strProperties.split(",");
        for (String arr1 : arr) {
            if (element.equalsIgnoreCase(arr1)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isValidEmail(String email) {
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        return pattern.matcher(email).matches();
    }

    public static <E> E choice(Collection<? extends E> coll) {
        if (coll.isEmpty()) {
            return null; // or throw IAE, if you prefer
        }
        return choice(coll, coll.size());
    }

    public static <E> E choice(Collection<? extends E> coll, int size) {
        Random rand = new Random();
        int index = rand.nextInt(size);
        try {
            if (coll instanceof List) { // optimization
                return ((List<? extends E>) coll).get(index);
            } else {
                Iterator<? extends E> iter = coll.iterator();
                for (int i = 0; i < index; i++) {
                    iter.next();
                }
                return iter.next();
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public static String subString(String message, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(message);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

//	public static JsonObject convertToJsonObject(Object obj) throws JsonProcessingException {
//		if (obj == null) {
//			return new JsonObject();
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//		String writeValueAsString = mapper.writeValueAsString(obj);
//		return new JsonObject(writeValueAsString);
//	}
//
//	public static JsonArray convertToJsonArray(Object obj) throws JsonProcessingException {
//		if (obj == null) {
//			return new JsonArray();
//		}
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
//		String writeValueAsString = mapper.writeValueAsString(obj);
//		return new JsonArray(writeValueAsString);
//	}

    public static String convertToJsonString(Object obj) throws JsonProcessingException {
        if (obj == null) {
            return "";
        }
        ObjectMapper mapper = new ObjectMapper();

        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        return mapper.writeValueAsString(obj);
    }

    public static String concatString(String... content) {
        StringBuilder builder = new StringBuilder();
        for (String str : content) {
            builder.append(str);
        }
        return builder.toString();
    }



}
