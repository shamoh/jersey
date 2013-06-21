/*
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2013 Oracle and/or its affiliates. All rights reserved.
 *
 * The contents of this file are subject to the terms of either the GNU
 * General Public License Version 2 only ("GPL") or the Common Development
 * and Distribution License("CDDL") (collectively, the "License").  You
 * may not use this file except in compliance with the License.  You can
 * obtain a copy of the License at
 * http://glassfish.java.net/public/CDDL+GPL_1_1.html
 * or packager/legal/LICENSE.txt.  See the License for the specific
 * language governing permissions and limitations under the License.
 *
 * When distributing the software, include this License Header Notice in each
 * file and include the License file at packager/legal/LICENSE.txt.
 *
 * GPL Classpath Exception:
 * Oracle designates this particular file as subject to the "Classpath"
 * exception as provided by Oracle in the GPL Version 2 section of the License
 * file that accompanied this code.
 *
 * Modifications:
 * If applicable, add the following below the License Header, with the fields
 * enclosed by brackets [] replaced by your own identifying information:
 * "Portions Copyright [year] [name of copyright owner]"
 *
 * Contributor(s):
 * If you wish your version of this file to be governed by only the CDDL or
 * only the GPL Version 2, indicate your decision by adding "[Contributor]
 * elects to include this software in this distribution under the [CDDL or GPL
 * Version 2] license."  If you don't indicate a single choice of license, a
 * recipient has the option to distribute your version of this file under
 * either the CDDL, the GPL Version 2 or to extend the choice of license to
 * its licensees as provided above.  However, if you add GPL Version 2 code
 * and therefore, elected the GPL Version 2 license, then the option applies
 * only if the new code is made subject to such option by the copyright
 * holder.
 */
package org.glassfish.jersey.servlet.spi;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import java.util.Set;

import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.servlet.ServletContainer;

/**
 * TODO
 * Extension point for {@link ServletContainerInitializer} without extending {@link JerseyServletContainerInitializer}
 * Only one JerseyServletContainerInitializerFactory implementation in application is allowed. ?!?!?!
 *
 * @author Libor Kramolis (libor.kramolis at oracle.com)
 */
public interface JerseyServletContainerInitializerFactory {

    /**
     * TODO
     * @param servletContext
     * @return
     */
    public boolean init(ServletContext servletContext) throws ServletException;

    /**
     * TODO
     * Method is invoked before {@link JerseyServletContainerInitializer#onStartup} implementation code.
     * @param classes Set can contain classes {@link javax.ws.rs.Path}, {@link Provider}, {@link Application},
     *          {@link ApplicationPath}. It is never {@code null}, TODO or #preOnStartup of previous JerseyServletContainerInitializerFactory
     * @param servletContext instance from {@link JerseyServletContainerInitializer#onStartup} call
     * @return usually returns {@code classes}, but it is possible to modify set of processed classes.
     *      The value is then used in {@link JerseyServletContainerInitializer#onStartup} implementation code and
     *      as first parameter on {@link #postOnStartup}.
     * @throws ServletException if an error has occurred
     */
    public Set<Class<?>> preOnStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException;

    /**
     * TODO
     * Method is invoked after {@link JerseyServletContainerInitializer#onStartup} implementation code.
     * @param classes Set contains classes returned by {@link #preOnStartup} method. TODO all #preOnStartup methods and impl code
     * @param servletContext instance from {@link JerseyServletContainerInitializer#onStartup} call
     * @throws ServletException if an error has occurred
     */
    public void postOnStartup(Set<Class<?>> classes, ServletContext servletContext) throws ServletException;

    /**
     * TODO
     * Return instance of your {@link ServletContainer} extension or return null. You can also configure ResourceConfig.
     *
     * @return may return {@code null}
     */
    public ServletContainer createServletContainer(ResourceConfig resourceConfig);

}
