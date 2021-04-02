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
package net.openurp.ecupl.spa.doc.certification.action

import net.openurp.ecupl.spa.doc.certification.service.GradeConverter
import org.beangle.data.dao.OqlBuilder
import org.beangle.security.Securities
import org.beangle.webmvc.api.action.ActionSupport
import org.beangle.webmvc.api.view.View
import org.beangle.webmvc.entity.action.EntityAction
import org.openurp.base.edu.model.Student
import org.openurp.boot.edu.helper.ProjectSupport
import org.openurp.edu.program.domain.DefaultProgramMatcher
import org.openurp.edu.program.model.Program

class MyAction extends ActionSupport with EntityAction[Student] with ProjectSupport {

  def zh(): View = {
    val std = getStudent
    put("grade", GradeConverter.getGrade(std))
    put("std", std)
    put("program", getProgram(std))
    forward(if (std.registed) "../zh" else "../no")
  }

  def en(): View = {
    val std = getStudent
    put("grade", GradeConverter.getGrade(std))
    put("std", std)
    put("program", getProgram(std))
    forward(if (std.registed) "../en" else "../no")
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

  private def getStudent: Student = {
    entityDao.findBy(classOf[Student], "user.code", List(Securities.user)).head
  }

}
