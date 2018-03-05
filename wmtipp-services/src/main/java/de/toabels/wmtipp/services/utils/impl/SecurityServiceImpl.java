/*
 * Copyright (C) 2018 Torsten Abels <torsten.abels@gmail.com>
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 */

package de.toabels.wmtipp.services.utils.impl;

import de.toabels.wmtipp.services.utiils.ISecurityService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import org.springframework.stereotype.Service;

/**
 *
 * @author abels
 */
@Service
public class SecurityServiceImpl implements ISecurityService {

  public static final String SALT = "PlZ3NcrYPtME";

  @Override
  public String getSaltedPassword(String password){
    return generateHash(SALT + password);
  }

  /**
   * Generate
   * @param input
   * @return 
   */
  @Override
  public String generateHash(String input) {
    StringBuilder hash = new StringBuilder();

    try {
      MessageDigest sha = MessageDigest.getInstance("SHA-1");
      byte[] hashedBytes = sha.digest(input.getBytes());
      char[] digits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
        'a', 'b', 'c', 'd', 'e', 'f'};
      for (int idx = 0; idx < hashedBytes.length; ++idx) {
        byte b = hashedBytes[idx];
        hash.append(digits[(b & 0xf0) >> 4]);
        hash.append(digits[b & 0x0f]);
      }
    } catch (NoSuchAlgorithmException e) {
      // handle error here.
    }

    return hash.toString();
  }
  
}
