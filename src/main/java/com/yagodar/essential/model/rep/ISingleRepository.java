/**
 * Ya-Essential. 
 * Essential tools for programming.
 * 
 * Copyright (C) 2014 Yagodarov Andrey <yagodarov.a.e@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.yagodar.essential.model.rep;

import com.yagodar.essential.model.Model;
import com.yagodar.essential.operation.OperationResult;

/**
 * @author Yagodarov Andrey <yagodarov.a.e@gmail.com>
 */
public interface ISingleRepository<T extends Model> {
    OperationResult<T> load();
    OperationResult<Long> insert();
    OperationResult<Long> insert(T model);
    OperationResult<Integer> update(T model);
    OperationResult<Integer> delete();
}
