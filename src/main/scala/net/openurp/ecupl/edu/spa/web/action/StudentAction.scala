/*
 * OpenURP, Agile University Resource Planning Solution.
 *
 * Copyright © 2014, The OpenURP Software.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful.
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.openurp.ecupl.edu.spa.web.action

import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.view.View
import org.beangle.webmvc.entity.action.EntityAction
import org.openurp.edu.base.model.Student
import org.openurp.edu.boot.web.ProjectSupport
import java.text.SimpleDateFormat
import org.openurp.base.model.Person

class StudentAction extends ActionSupport with EntityAction[Student] with ProjectSupport {

  def zh(): View = {
    val std = getStudent
    put("grade", getGrade(std))
    put("std", std)
    forward()
  }

  def en(): View = {
    val std = getStudent
    val grade = getGrade(std)
    put("grade", grade)
    put("std", std)
    if (grade >= 4) {
      put("lineheight", 140)
      put("fontSize", 20)
    } else {
      put("lineheight", 230)
      put("fontSize", 22)
    }
    forward()
  }

  private def getGrade(std: Student): Int = {
    val format = new SimpleDateFormat("yyyyMM")
    val year = std.beginOn.getYear
    val month = std.beginOn.getMonth.getValue
    val date = format.format(new java.util.Date)
    val y = Integer.parseInt(date.substring(0, 4))
    val m = Integer.parseInt(date.substring(4))
    var grade = 1
    if (year == y) {
      grade = 1
    } else if (y > year) {
      if (m >= month) {
        grade = y - year + 1
      } else {
        grade = y - year
      }
    }
    grade
  }
}
