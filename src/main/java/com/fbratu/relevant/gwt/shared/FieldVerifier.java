package com.fbratu.relevant.gwt.shared;

/**
 * Input validation
 */
public class FieldVerifier {

   // location should be an alphanumeric string
   private static final String LOCATION_REGEXP = "[a-zA-Z0-9]+";

  /**
   * check input location
   *
   * @param location the search location
   * @return true if valid, false if invalid
   */
  public static boolean isValidName(String location) {
    if (location == null || "".equals(location)) {
      return false;
    }
    return location.matches(LOCATION_REGEXP);
  }
}
