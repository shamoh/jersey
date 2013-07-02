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
package org.glassfish.jersey.servlet.internal;

import java.util.logging.Logger;
import javax.servlet.ServletException;

import org.glassfish.jersey.internal.ServiceFinder;
import org.glassfish.jersey.servlet.internal.spi.ServletContainerProvider;

/**
 * TODO
 *
 * @author Libor Kramolis (libor.kramolis at oracle.com)
 */
public final class ServletContainerProviderFactory {

    private static final Logger LOGGER = Logger.getLogger(ServletContainerProviderFactory.class.getName());

    private ServletContainerProviderFactory() {
    }

    /**
     * TODO
     *
     * @return TODO. Never returns null.
     * @throws ServletException
     */
    public static ServletContainerProvider[] getAllServletContainerProviders() throws ServletException {
        ServletContainerProvider[] allServletContainerProviders = ServiceFinder.find(ServletContainerProvider.class).toArray();
        return allServletContainerProviders;
    }

/*
    public static ServletContainerProvider createServletContainerProvider() throws ServletException {
        ServletContainerProvider servletContainerProvider = null;
        Iterator<ServletContainerProvider> factoryServiceIterator =
                ServiceFinder.find(ServletContainerProvider.class).iterator();
        if (factoryServiceIterator.hasNext()) {
            servletContainerProvider = factoryServiceIterator.next();
            if (factoryServiceIterator.hasNext()) {
                if (LOGGER.isLoggable(Level.SEVERE)) {
                    LOGGER.severe(LocalizationMessages.TOO_MANY_SERVLET_CONTAINER_PROVIDERS());
                    for (; factoryServiceIterator.hasNext(); servletContainerProvider = factoryServiceIterator.next()) {
                        final String className = servletContainerProvider.getClass().getName();
                        final String codeSourceLocation = servletContainerProvider.getClass().getProtectionDomain().
                                getCodeSource().getLocation().toString();
                        LOGGER.severe(LocalizationMessages.FOUND_SERVLET_CONTAINER_PROVIDER(className, codeSourceLocation));
                    }
                }
                throw new ServletException(LocalizationMessages.EXCEPTION_TOO_MANY_SERVLET_CONTAINER_PROVIDERS());
            }
        } else {
            servletContainerProvider = new DefaultServletContainerProvider();
        }
        return servletContainerProvider;
    }


    private static class DefaultServletContainerProvider implements ServletContainerProvider {

        @Override
        public void configure(ServletContext servletContext, ResourceConfig resourceConfig) throws ServletException {
            System.out.println("### DefaultServletContainerProvider.configure");
            //NOP
        }

    } // class DefaultServletContainerProvider
*/

}
