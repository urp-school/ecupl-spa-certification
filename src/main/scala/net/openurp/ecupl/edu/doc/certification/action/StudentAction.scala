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
package net.openurp.ecupl.edu.doc.certification.action

import net.openurp.ecupl.edu.doc.certification.service.GradeConverter
import org.beangle.data.dao.OqlBuilder
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.annotation.{action, param}
import org.beangle.webmvc.api.view.{Status, View}
import org.beangle.webmvc.entity.action.EntityAction
import org.openurp.edu.base.model.Student
import org.openurp.edu.base.web.ProjectSupport
import org.openurp.edu.program.domain.DefaultProgramMatcher
import org.openurp.edu.program.model.Program

@action("{code}")
class StudentAction extends ActionSupport with EntityAction[Student] with ProjectSupport {

  def zh(@param("code") code: String): View = {
    val stds = entityDao.findBy(classOf[Student], "user.code", List(code))
    if (stds.isEmpty) {
      Status.NotFound
    } else {
      val std = stds.head
      put("grade", GradeConverter.getGrade(std))
      put("std", std)
      put("program", getProgram(std))
      forward("../zh")
    }
  }

  def en(@param("code") code: String): View = {
    val stds = entityDao.findBy(classOf[Student], "user.code", List(code))
    if (stds.isEmpty) {
      Status.NotFound
    } else {
      val std = stds.head
      put("grade", GradeConverter.getGrade(std))
      put("std", std)
      put("program", getProgram(std))
      forward("../en")
    }
  }

  private def getProgram(std: Student): Option[Program] = {
    std.state match {
      case None => None
      case Some(state) =>
        val query = OqlBuilder.from(classOf[Program], "p")
        query.where("p.grade=:grade", state.grade)
        query.where("p.department=:department", state.department)
        query.where("p.major=:major", state.major)
        query.where("p.level=:level", std.level)
        val ps = entityDao.search(query)
        ps.filter(DefaultProgramMatcher.isMatched(_, state)).headOption
    }
  }
}
